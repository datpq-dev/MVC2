/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datpq.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class CartObj implements Serializable {

    private Map<String, Integer> items;

    public Map<String, Integer> getItems() {
        return items;
    }

    public boolean addItemToCart(String id, int quantity) {
        boolean result = false;
        //1. Check data validation
        if (id == null) {
            return result;
        }
        if (id.trim().isEmpty()) {
            return result;
        }
        if (quantity <= 0) {
            return result;
        }
        //2. Check existed items
        if (this.items == null) {
            this.items = new HashMap<>();
        }// end items had NOT existed
        //3. drop item to items
        if (this.items.containsKey(id)) {
            int quan = items.get(id);// available
            quantity = quantity + quan;
        }//end item had existed
        //4. update items
        items.put(id, quantity);
        result = true;

        return result;
    }

    public boolean deleteItemFromCart(String id) {
        boolean result = false;
        if (id == null) {
            return result;
        }
        if (id.trim().isEmpty()) {
            return result;
        }
        this.items.remove(id);
        return true;
    }

    public boolean removeItemFromCart(String id, int quantity) {
        boolean result = false;
        //1. Check data validation
        if (id == null) {
            return result;
        }
        if (id.trim().isEmpty()) {
            return result;
        }
        if (quantity <= 0) {
            return result;
        }
        //2. Check existed items
        if (this.items == null) {
            return result;
        }
        //3. Check existed item
        if (this.items.containsKey(id)) {
            //4. compare quantity
            int quan = this.items.get(id);// available

            if (quan < quantity) {
                return result;
            }// available quantity smaller than removed quantity
            quantity = quan - quantity;
            if (quantity <= 0) {
                this.items.remove(id);
                if (this.items.isEmpty()) {
                    this.items = null;
                }// empty cart whe items has NOT existed 
            } else {
                this.items.put(id, quantity);// update cart items
            }
            result = true;
        }//end item had existed
        return result;
    }

}
