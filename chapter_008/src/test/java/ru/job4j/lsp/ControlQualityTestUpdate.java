package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;

import ru.job4j.lsp.food.*;
import ru.job4j.lsp.storage.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * ControlQuality test with new functionality
 *
 * @author Kondratkov Anton
 * @since 1.09.2019
 */
public class ControlQualityTestUpdate {
    private final LocalDate now = LocalDate.now();
    private List<Storage> storages;
    private Storage trash;
    private Storage reprocess;
    private Storage shop;
    private Storage warehouse;
    private Storage warehouseNew;
    private Storage refrigerator;

    private final Kefir kefirExpaireRate5 = new Kefir("kefir", now.plusDays(95), now.minusDays(5), new BigDecimal("84.21"), 0);
    private final Potato potatoExpaireRate5 = new Potato("potato", now.plusDays(95), now.minusDays(5), new BigDecimal("41.25"), 0);
    private final Kefir kefirExpaireRate100 = new Kefir("kefir", now.plusDays(0), now.minusDays(100), new BigDecimal("35.58"), 0);
    private final Meat meatExpaireRate100 = new Meat("meat", now.plusDays(0), now.minusDays(100), new BigDecimal("24.11"), 0);
    private final Kefir kefirExpaireRate93 = new Kefir("kefir", now.plusDays(7), now.minusDays(93), new BigDecimal("84.21"), 0);
    private final Potato potatoExpaireRate16 = new Potato("potato", now.plusDays(84), now.minusDays(16), new BigDecimal("1.00"), 0);


    @Before
    public void before() {
        trash = new Storage(new AddToTrashNonReproduct(new Trash()));
        reprocess = new Storage(new ReproductStorage(new Trash()));
        shop = new Storage(new Shop());
        warehouse = new Storage(new Skip());
        warehouseNew = new Storage(new AddToWarehouseNonVegetable(new Warehouse()));
        refrigerator = new Storage(new Refrigerator(new Warehouse()));


        storages = List.of(trash, shop, warehouse, warehouseNew, reprocess, refrigerator);
    }

    @Test
    public void whenExpaireRate5AndNonVegetableShouldAddToWarehouseNewWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(kefirExpaireRate5);

        assertThat(kefirExpaireRate5.getExpaireRate(), is(5));
        assertThat(kefirExpaireRate5.getDiscount(), is(0));
        assertThat(warehouseNew.getFoods(), hasItem(kefirExpaireRate5));
        assertThat(warehouse.getFoods(), not(hasItem(kefirExpaireRate5)));
    }

    @Test
    public void whenExpaireRate5AndVegetableShouldAddToRefrigeratorWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(potatoExpaireRate5);

        assertThat(potatoExpaireRate5.getExpaireRate(), is(5));
        assertThat(potatoExpaireRate5.getDiscount(), is(0));
        assertThat(refrigerator.getFoods(), hasItem(potatoExpaireRate5));
        assertThat(warehouseNew.getFoods(), not(hasItem(potatoExpaireRate5)));
        assertThat(warehouse.getFoods(), not(hasItem(potatoExpaireRate5)));
    }

    @Test
    public void whenExpaireRate100AndReproductShouldAddToReproductWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(kefirExpaireRate100);

        assertThat(kefirExpaireRate100.getExpaireRate(), is(100));
        assertThat(kefirExpaireRate100.getDiscount(), is(0));
        assertThat(reprocess.getFoods(), hasItem(kefirExpaireRate100));
        assertThat(trash.getFoods(), not(hasItem(kefirExpaireRate100)));
    }

    @Test
    public void whenExpaireRate100AndNonReproductShouldAddToTrashWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(meatExpaireRate100);

        assertThat(meatExpaireRate100.getExpaireRate(), is(100));
        assertThat(meatExpaireRate100.getDiscount(), is(0));
        assertThat(trash.getFoods(), hasItem(meatExpaireRate100));
        assertThat(reprocess.getFoods(), not(hasItem(meatExpaireRate100)));
    }


    @Test
    public void whenAddingProductsChangesFromShopToReprocess() {
        ControllQuality controllQuality = new ControllQuality(storages);

        controllQuality.addToStorage(kefirExpaireRate93);

        assertThat(kefirExpaireRate93.getExpaireRate(), is(93));
        assertThat(kefirExpaireRate93.getDiscount(), is(5));
        assertThat(warehouse.getFoods(), not(hasItem(kefirExpaireRate93)));
        assertThat(reprocess.getFoods(), not(hasItem(kefirExpaireRate93)));
        assertThat(shop.getFoods(), hasItem(kefirExpaireRate93));

        controllQuality.resort();

        assertThat(kefirExpaireRate93.getExpaireRate(), is(93));
        assertThat(kefirExpaireRate93.getDiscount(), is(0));
        assertThat(warehouse.getFoods(), not(hasItem(kefirExpaireRate93)));
        assertThat(reprocess.getFoods(),  hasItem(kefirExpaireRate93));
        assertThat(shop.getFoods(), not(hasItem(kefirExpaireRate93)));
    }

    @Test
    public void whenAddingProductsChangesFromRefrigeratorToShop() {
        ControllQuality controllQuality = new ControllQuality(storages);

        controllQuality.addToStorage(potatoExpaireRate16);

        assertThat(potatoExpaireRate16.getExpaireRate(), is(16));
        assertThat(potatoExpaireRate16.getDiscount(), is(0));
        assertThat(warehouse.getFoods(), not(hasItem(potatoExpaireRate16)));
        assertThat(trash.getFoods(), not(hasItem(potatoExpaireRate16)));
        assertThat(shop.getFoods(), not(hasItem(potatoExpaireRate16)));
        assertThat(refrigerator.getFoods(), hasItem(potatoExpaireRate16));
        assertThat(reprocess.getFoods(), not(hasItem(potatoExpaireRate16)));

        controllQuality.resort();

        assertThat(potatoExpaireRate16.getExpaireRate(), is(16));
        assertThat(potatoExpaireRate16.getDiscount(), is(0));
        assertThat(warehouse.getFoods(), not(hasItem(potatoExpaireRate16)));
        assertThat(trash.getFoods(), not(hasItem(potatoExpaireRate16)));
        assertThat(shop.getFoods(), hasItem(potatoExpaireRate16));
        assertThat(refrigerator.getFoods(), not(hasItem(potatoExpaireRate16)));
    }
}
