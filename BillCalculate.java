package test;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BillCalculate   {
    Map<Integer,Fruits> fruitsHashMap = new HashMap<>();

    public int fullDiscountFlag;

    private final BigDecimal fullDiscountLimit = new BigDecimal(100);
    private final BigDecimal fullDiscount = new BigDecimal(10);

    public BillCalculate() {
        fullDiscountFlag = 0;
        fruitsHashMap.put(1,new Fruits(1,"apple",new BigDecimal(8)));
        fruitsHashMap.put(2,new Fruits(2,"strawberry",new BigDecimal(13)));
        fruitsHashMap.put(3,new Fruits(3,"mango",new BigDecimal(20)));
    }

    /**
     * 计算水果价格总和
     * @param billDetailsList
     * @return
     */
    public BigDecimal fruitsPriceCalculateSum(@NotNull List<BillDetails> billDetailsList){
        BigDecimal priceSum = BigDecimal.ZERO;
        for (BillDetails billDetails: billDetailsList) {
            int fruitsId = billDetails.getId();
            String weight = billDetails.getWeight();
            Fruits fruits =  fruitsHashMap.get(fruitsId);
            BigDecimal price = fruits.getPrice();
            int discount_flag = fruits.getDiscount_flag();
            BigDecimal sum;
            if(discount_flag == 0){
                sum = fruitCalculateSum(weight,price);
            }else{
                String discount = fruits.getDiscount();
                sum = discountCalculateSum(weight,price,discount);
            }
            priceSum = priceSum.add(sum);
        }
        if(fullDiscountFlag == 1){
            priceSum = fullDiscountCalculate(priceSum);
        }
        //return priceSum.setScale(2,RoundingMode.HALF_UP);
        return priceSum;
    }

    /**
     * 计算某样水果价格 重量*金额
     * @param weight
     * @param price
     * @return
     */
    public BigDecimal fruitCalculateSum(String weight, @NotNull BigDecimal price){
        return price.multiply(new BigDecimal(weight));
    }

    /**
     * 计算打折后单价
     * @param weight
     * @param price
     * @param discount
     * @return
     */
    public BigDecimal discountCalculateSum(String weight, @NotNull BigDecimal price, String discount){
        // 打折除以10
        BigDecimal discountPrice = price.multiply(new BigDecimal(discount));
        return fruitCalculateSum(weight,discountPrice);
    }

    /**
     * 计算满减折扣优惠后金额
     * @param priceSum
     * @return
     */
    public BigDecimal fullDiscountCalculate(@NotNull BigDecimal priceSum){

        BigDecimal num = priceSum.divide(fullDiscountLimit,0, RoundingMode.DOWN);
        return priceSum.subtract(fullDiscount.multiply(num));
    }

    public Map<Integer, Fruits> getFruitsHashMap() {
        return fruitsHashMap;
    }

    public void setFruitsHashMap(Map<Integer, Fruits> fruitsHashMap) {
        this.fruitsHashMap = fruitsHashMap;
    }

    public int getFullDiscountFlag() {
        return fullDiscountFlag;
    }

    public void setFullDiscountFlag(int fullDiscountFlag) {
        this.fullDiscountFlag = fullDiscountFlag;
    }
}


