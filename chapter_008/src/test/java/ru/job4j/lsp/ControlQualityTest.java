package ru.job4j.lsp;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.lsp.food.Kefir;
import ru.job4j.lsp.food.Meat;
import ru.job4j.lsp.food.Potato;
import ru.job4j.lsp.storage.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * ControlQuality test.
 *
 * @author Kondratkov Anton
 * @since 31.08.2019
 */
public class ControlQualityTest {

    private final LocalDate now = LocalDate.now();
    private List<Storage> storages;
    private Storage trash;
    private Storage shop;
    private Storage warehouse;

    private final Kefir kefirExpaireRate5 = new Kefir("kefir", now.plusDays(95), now.minusDays(5), new BigDecimal("84.21"), 0);
    private final Potato potatoExpaireRate25 = new Potato("potato", now.plusDays(75), now.minusDays(25), new BigDecimal("84.21"), 0);
    private final Meat meatExpaireRate75 = new Meat("meat", now.plusDays(25), now.minusDays(75), new BigDecimal("84.21"), 0);
    private final Kefir kefirExpaireRate76 = new Kefir("kefir", now.plusDays(24), now.minusDays(76), new BigDecimal("32.11"), 25);
    private final Potato potatoExpaireRate100 = new Potato("potato", now.plusDays(0), now.minusDays(100), new BigDecimal("1.00"), 0);
    private final Meat meatExpaired = new Meat("meat", now.minusDays(1), now.minusDays(101), new BigDecimal("0.00"), 0);
    private final Kefir kefirExpaireRate93 = new Kefir("kefir", now.plusDays(7), now.minusDays(93), new BigDecimal("84.21"), 0);
    private final Meat meatExpaireRate20 = new Meat("meat", now.plusDays(80), now.minusDays(20), new BigDecimal("84.21"), 0);


    @Before
    public void before() {
        trash = new Storage(new Trash());
        shop = new Storage(new Shop());
        warehouse = new Storage(new Warehouse());
        storages = List.of(trash, shop, warehouse);
    }

    @Test
    public void whenExpaireRate76ShouldAddToShopWithDiscount5() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(kefirExpaireRate76);

        assertThat(kefirExpaireRate76.getExpaireRate(), is(76));
        assertThat(kefirExpaireRate76.getDiscount(), is(25));
        assertThat(shop.getFoods(), hasItem(kefirExpaireRate76));
        assertThat(trash.getFoods(), not(hasItem(kefirExpaireRate76)));
        assertThat(warehouse.getFoods(), not(hasItem(kefirExpaireRate76)));
    }

    @Test
    public void whenExpaireRate75ShouldAddToShopWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(meatExpaireRate75);

        assertThat(meatExpaireRate75.getExpaireRate(), is(75));
        assertThat(meatExpaireRate75.getDiscount(), is(0));
        assertThat(shop.getFoods(), hasItem(meatExpaireRate75));
        assertThat(trash.getFoods(), not(hasItem(meatExpaireRate75)));
        assertThat(warehouse.getFoods(), not(hasItem(meatExpaireRate75)));
    }

    @Test
    public void whenExpaireRate25ShouldAddToShopWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(potatoExpaireRate25);

        assertThat(potatoExpaireRate25.getExpaireRate(), is(25));
        assertThat(potatoExpaireRate25.getDiscount(), is(0));
        assertThat(shop.getFoods(), hasItem(potatoExpaireRate25));
        assertThat(trash.getFoods(), not(hasItem(potatoExpaireRate25)));
        assertThat(warehouse.getFoods(), not(hasItem(potatoExpaireRate25)));
    }

    @Test
    public void whenExpaireRate5ShouldAddToWarehouseWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(kefirExpaireRate5);

        assertThat(kefirExpaireRate5.getExpaireRate(), is(5));
        assertThat(kefirExpaireRate5.getDiscount(), is(0));
        assertThat(warehouse.getFoods(), hasItem(kefirExpaireRate5));
        assertThat(trash.getFoods(), not(hasItem(kefirExpaireRate5)));
        assertThat(shop.getFoods(), not(hasItem(kefirExpaireRate5)));

    }

    @Test
    public void whenExpaireRate100ShouldAddToTrashWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(potatoExpaireRate100);

        assertThat(potatoExpaireRate100.getExpaireRate(), is(100));
        assertThat(potatoExpaireRate100.getDiscount(), is(0));
        assertThat(trash.getFoods(), hasItem(potatoExpaireRate100));
        assertThat(warehouse.getFoods(), not(hasItem(potatoExpaireRate100)));
        assertThat(shop.getFoods(), not(hasItem(potatoExpaireRate100)));
    }

    @Test
    public void whenExpairedShouldAddToTrashWithoutDiscount() {
        ControllQuality controllQuality = new ControllQuality(storages);
        controllQuality.addToStorage(meatExpaired);

        assertThat(meatExpaired.getExpaireRate(), is(100));
        assertThat(meatExpaired.getDiscount(), is(0));
        assertThat(trash.getFoods(), hasItem(meatExpaired));
        assertThat(warehouse.getFoods(), not(hasItem(meatExpaired)));
        assertThat(shop.getFoods(), not(hasItem(meatExpaired)));
    }

    @Test
    public void whenAddingProductsChangesFromShopToTrash() {
        ControllQuality controllQuality = new ControllQuality(storages);

        controllQuality.addToStorage(kefirExpaireRate93);

        assertThat(kefirExpaireRate93.getExpaireRate(), is(93));
        assertThat(kefirExpaireRate93.getDiscount(), is(5));
        assertThat(warehouse.getFoods(), not(hasItem(kefirExpaireRate93)));
        assertThat(trash.getFoods(), not(hasItem(kefirExpaireRate93)));
        assertThat(shop.getFoods(), hasItem(kefirExpaireRate93));

        controllQuality.resort();

        assertThat(kefirExpaireRate93.getExpaireRate(), is(93));
        assertThat(kefirExpaireRate93.getDiscount(), is(0));
        assertThat(warehouse.getFoods(), not(hasItem(kefirExpaireRate93)));
        assertThat(trash.getFoods(), hasItem(kefirExpaireRate93));
        assertThat(shop.getFoods(), not(hasItem(kefirExpaireRate93)));
    }

    @Test
    public void whenAddingProductsChangesFromWarehouseToShop() {
        ControllQuality controllQuality = new ControllQuality(storages);

        controllQuality.addToStorage(meatExpaireRate20);

        assertThat(warehouse.getFoods(), hasItem(meatExpaireRate20));
        assertThat(trash.getFoods(), not(hasItem(meatExpaireRate20)));
        assertThat(shop.getFoods(), not(hasItem(meatExpaireRate20)));

        controllQuality.resort();

        assertThat(warehouse.getFoods(), not(hasItem(meatExpaireRate20)));
        assertThat(trash.getFoods(), not(hasItem(meatExpaireRate20)));
        assertThat(shop.getFoods(), hasItem(meatExpaireRate20));
    }
}
