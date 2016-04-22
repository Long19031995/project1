/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Check;

import business.Product;
import static data.ProductIO.getProduct;

/**
 *
 * Coder: Trần Hà Ngọc Thiện ID: B13DCCN338
 */
public class CheckException {
    
    public static boolean checkProductCode(String productCode) {
        return !productCode.equals("");
    }

    //kiểm tra xem productCode đã xuất hiện hay chưa
    public static boolean checkProductCode(String productCode, String path) {
        Product product = getProduct(productCode, path);
        
        return product == null;
    }

    //kiểm tra xem productDescription có hợp lệ hay không
    public static boolean checkProductDescription(String productDescription) {
        return !"".equals(productDescription);
    }
    
    public static boolean checkProductPrice1(String productPrice) {
        return !productPrice.equals("");
    }

    //kiểm tra xem productPrice có hợp lệ hay không
    public static boolean checkProductPrice2(String productPrice) {
        try {
            double doub = Double.parseDouble(productPrice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
