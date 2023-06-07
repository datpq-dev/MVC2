/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datpq.util;

/**
 *
 * @author ASUS
 */
public class MyApplicationConstants {

    public class DispatchFeature {

        public static final String LOGIN_PAGE = "loginPage";
        public static final String LOGIN_CONTROLLER = "loginController";
    }

    public class LoginFeature {

        public static final String INVALID_PAGE = "invalidPage";
        public static final String SEARCH_PAGE = "searchPage";
        public static final String LOG_OUT_CONTROLLER = "logOutController";
    }

    public class SearchFeature {

        public static final String SEARCH_CONTROLLER = "searchController";
        public static final String UPDATE_CONTROLLER = "updateController";
        public static final String DELETE_CONTROLLER = "deleteController";
        public static final String UPDATE_ERRPAGE = "updateErrorPage";
        public static final String DELETE_ERRPAGE = "deleteErrorPage";
    }

    public class ShoppingFeature {

        public static final String SHOPPING_PAGE = "shoppingPage";
        public static final String STORE_CART_CONTROLLER = "shoppingController";
        public static final String ADD_ITEM_TO_CART_CONTROLLER = "addItemToCartController";
        public static final String VIEW_CART_PAGE = "viewCart";
        public static final String REMOVE_CART_CONTROLLER = "removeController";
        public static final String DELETE_CART_CONTROLLER = "deleteItemController";
    }

    public class CreateAccountFeature {

        public static final String INSERT_ERROR_PAGE = "createAccountErrPage";
        public static final String CREATE_NEW_ACCOUNT_CONTROLLER = "createAccountController";
    }
}
