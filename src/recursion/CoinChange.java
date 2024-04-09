package recursion;


import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {

//    Задание 3
//Есть монеты достоинством 10, 5, 3 и 2 копейки. На вход передаётся массив, с имеющимся набором монет
//(значение элемента определяет достоинство монеты) и сумма, которую нужно заплатить.
//Напишите рекурсивную функцию которая должна определить, можно ли заплатить требуемую сумму имеющимися монетами.
//
//
//Пример:
//  canPay([5, 5, 3, 3, 2], 11) вернёт true
//  canPay([5, 5, 3, 3, 2], 12) вернёт true
//  canPay([5, 5, 3, 3, 2], 4)  вернёт false
//  canPay([5, 2, 5, 5, 2], 13) вернёт false
//  canPay([3, 2, 10, 2, 3], 16) вернёт true
//  canPay([3, 2, 10, 2, 5], 16) вернёт false

    public static void main(String[] args) {
        int[] coins = {3, 2, 10, 2, 5};
        int sum = 16;
        System.out.println(canPay(coins, sum));

    }
    public static boolean canPay (int[] coins, int sum){
        return canPayIndex (coins, 0, sum);

    }
    private static boolean canPayIndex(int[] coins, int index, int sum){
        if(sum == 0) {
            return true;
        }
        if(index >= coins.length || sum < 0) {
            return false;

        }
        return canPayIndex(coins, index + 1, sum - coins[index]) || canPayIndex(coins, index + 1, sum);
    }

}
