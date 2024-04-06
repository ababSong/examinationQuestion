package test;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDemo {
    //第一题
    @Test
    public void one(){
        BillCalculate billCalculate = new BillCalculate();
        //创建订单
        List<BillDetails> billDetailsList= new ArrayList<>();
        billDetailsList.add(new BillDetails(1, "apple", "5.6"));
        billDetailsList.add(new BillDetails(2, "strawberry", "8.4"));
        BigDecimal priceSum = billCalculate.fruitsPriceCalculateSum(billDetailsList);
        System.out.println(priceSum);
    }

    //第二题
    @Test
    public void tow(){
        BillCalculate billCalculate = new BillCalculate();
        //创建订单
        List<BillDetails> billDetailsList= new ArrayList<>();
        billDetailsList.add(new BillDetails(1, "apple", "0.3"));
        billDetailsList.add(new BillDetails(2, "strawberry", "0.5"));
        billDetailsList.add(new BillDetails(3, "mango", "0.80025"));
        BigDecimal priceSum = billCalculate.fruitsPriceCalculateSum(billDetailsList);
        System.out.println(priceSum);
    }

    //第三题
    @Test
    public void three(){
        BillCalculate billCalculate = new BillCalculate();
        Map<Integer,Fruits> fruitsHashMap;
        fruitsHashMap = billCalculate.getFruitsHashMap();
        fruitsHashMap.get(2).setDiscount("0.8");
        fruitsHashMap.get(2).setDiscount_flag(1);
        billCalculate.setFruitsHashMap(fruitsHashMap);
        //创建订单
        List<BillDetails> billDetailsList= new ArrayList<>();
        billDetailsList.add(new BillDetails(1, "apple", "5"));
        billDetailsList.add(new BillDetails(2, "strawberry", "10"));
        billDetailsList.add(new BillDetails(3, "mango", "4.2"));
        BigDecimal priceSum = billCalculate.fruitsPriceCalculateSum(billDetailsList);
        System.out.println(priceSum);
    }

    //第四题
    @Test
    public void four(){
        BillCalculate billCalculate = new BillCalculate();
        //开启满减
        billCalculate.setFullDiscountFlag(1);
        Map<Integer,Fruits> fruitsHashMap;
        fruitsHashMap = billCalculate.getFruitsHashMap();
        fruitsHashMap.get(2).setDiscount("0.8");
        fruitsHashMap.get(2).setDiscount_flag(1);
        billCalculate.setFruitsHashMap(fruitsHashMap);
        //创建订单 99.99
        List<BillDetails> billDetailsList= new ArrayList<>();
        billDetailsList.add(new BillDetails(1, "apple", "0.5"));
        billDetailsList.add(new BillDetails(2, "strawberry", "1.5375"));
        billDetailsList.add(new BillDetails(3, "mango", "4"));
        BigDecimal priceSum = billCalculate.fruitsPriceCalculateSum(billDetailsList);
        System.out.println(priceSum);
        //创建订单 100.01
        List<BillDetails> billDetailsList101= new ArrayList<>();
        billDetailsList101.add(new BillDetails(1, "apple", "0.5"));
        billDetailsList101.add(new BillDetails(2, "strawberry", "1.5375"));
        billDetailsList101.add(new BillDetails(3, "mango", "4.001"));
        priceSum = billCalculate.fruitsPriceCalculateSum(billDetailsList101);
        System.out.println(priceSum);
    }

}
