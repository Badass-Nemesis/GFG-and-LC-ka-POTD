import java.util.*;

class test {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = scn.nextInt();
            hm.put(temp, hm.getOrDefault(temp, 0) + 1);
        }
        int m = scn.nextInt();

        int sum = 0;
        for (int key : hm.keySet()) {
            sum += (hm.get(key) / m) * key;
            sum += (hm.get(key) % m) * key;
        }

        System.out.println(sum);
        scn.close();
    }
}