package test;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

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
        billDetailsList.add(new BillDetails(1, "apple", "1.54"));
        billDetailsList.add(new BillDetails(2, "strawberry", "2.66"));
        BigDecimal priceSum = billCalculate.fruitsPriceCalculateSum(billDetailsList);
        Assert.isTrue(priceSum.compareTo(new BigDecimal("46.9")) == 0,
                "第一题金额计算测试失败"+ priceSum.toString());
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
        Assert.isTrue(priceSum.compareTo(new BigDecimal("24.905")) == 0,
                "第二题金额计算测试失败" + priceSum.toString());
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
        Assert.isTrue(priceSum.compareTo(new BigDecimal("228")) == 0,
                "第三题折扣金额计算测试失败"+ priceSum.toString());
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
        Assert.isTrue(priceSum.compareTo(new BigDecimal("99.99")) == 0,
                "第4题满减金额边界值测试99.99失败"+ priceSum.toString());
        //创建订单 100.01
        List<BillDetails> billDetailsList101= new ArrayList<>();
        billDetailsList101.add(new BillDetails(1, "apple", "0.5"));
        billDetailsList101.add(new BillDetails(2, "strawberry", "1.5375"));
        billDetailsList101.add(new BillDetails(3, "mango", "4.001"));
        priceSum = billCalculate.fruitsPriceCalculateSum(billDetailsList101);
        Assert.isTrue(priceSum.compareTo(new BigDecimal("90.01")) == 0,
                "第4题满减金额边界值测试100.01失败"+ priceSum.toString());
    }

}
