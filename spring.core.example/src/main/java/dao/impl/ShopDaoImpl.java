package dao.impl;

import dao.ShopDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import model.Shop;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
public class ShopDaoImpl implements ShopDao {

    private List<Shop> shopTable;

    public ShopDaoImpl() {
        this.shopTable = new ArrayList<>();
    }

    @Override
    public List<Shop> readAll() {
        return shopTable;
    }

    @Override
    public Shop read(int id) {
        return shopTable.stream()
                .filter(shop -> shop.getId() == id)
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public void create(Shop o) {
        if (!shopTable.contains(o)) {
            shopTable.add(o);
        }
    }

    @Override
    public void update(Shop o) {
        if (shopTable.contains(o)) {
            Shop shopToUpdate = shopTable.stream()
                    .filter(s -> s.getId() == o.getId())
                    .findFirst()
                    .orElseThrow(NullPointerException::new);
            int index = shopTable.indexOf(shopToUpdate);
            shopToUpdate.setName(o.getName());
            shopToUpdate.setSquare(o.getSquare());
            shopToUpdate.setMaxPeople(o.getMaxPeople());
            shopTable.set(index, shopToUpdate);
        }
    }

    @Override
    public void delete(int id) {
        Shop shopToDelete = read(id);
        if (shopTable.contains(shopToDelete)) {
            shopTable.remove(shopToDelete);
        }
    }
}
