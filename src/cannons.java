import java.util.Scanner;

public class cannons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        sc.nextLine();
        for (int w = 0; w < testcases; w++) {
            int aCannonCount = sc.nextInt();
            int bCannonCount = sc.nextInt();
            int aHealth = sc.nextInt();
            int bHealth = sc.nextInt();
            cannon[] aCannons = new cannon[aCannonCount];
            cannon[] bCannons = new cannon[bCannonCount];
            sc.nextLine();
            for (int i = 0; i < aCannonCount; i++) {
                String[] input = sc.nextLine().split(" ");
                aCannons[i] = new cannon(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]), 0, 0);
            }
            for (int i = 0; i < bCannonCount; i++) {
                String[] input = sc.nextLine().split(" ");
                bCannons[i] = new cannon(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]), 0, 0);
            }
            int time = 0;
            while (true) {
                time += 1;
                int aTotalDamage = 0;
                int bTotalDamage = 0;
                boolean aType2Shot = false;
                boolean bType2Shot = false;
                for (cannon c : aCannons) {
                    if (time >= c.onTime) {
                        c.coolDownTimer += 1;
                        if (c.coolDownTimer >= c.coolDown)
                            c.chargeTimer += 1;
                        if (c.chargeTimer >= c.chargeTime) {
                            c.chargeTimer = 0;
                            c.coolDownTimer = 0;
                            if (c.type == 2)
                                aType2Shot = true;
                            aTotalDamage += c.damage;
                        }
                    }
                }
                for (cannon c : bCannons) {
                    if (time >= c.onTime) {
                        c.coolDownTimer += 1;
                        if (c.coolDownTimer >= c.coolDown)
                            c.chargeTimer += 1;
                        if (c.chargeTimer >= c.chargeTime) {
                            c.chargeTimer = 0;
                            c.coolDownTimer = 0;
                            if (c.type == 2)
                                bType2Shot = true;
                            bTotalDamage += c.damage;
                        }
                    }
                }
                if (aTotalDamage > bTotalDamage) {
                    bHealth -= aTotalDamage;
                    if (aType2Shot)
                        for (cannon b : bCannons)
                            b.chargeTimer = 0;
                } else if (aTotalDamage < bTotalDamage) {
                    aHealth -= bTotalDamage;
                    if (bType2Shot)
                        for (cannon a : aCannons)
                            a.chargeTimer = 0;
                } else if (aHealth > bHealth) {
                    bHealth -= aTotalDamage;
                    if (aType2Shot)
                        for (cannon b : bCannons)
                            b.chargeTimer = 0;
                } else if (aHealth < bHealth) {
                    aHealth -= bTotalDamage;
                    if (bType2Shot)
                        for (cannon a : aCannons)
                            a.chargeTimer = 0;
                } else {
                    bHealth -= aTotalDamage;
                    if (aType2Shot)
                        for (cannon b : bCannons)
                            b.chargeTimer = 0;
                }
                if (aHealth <= 0) {
                    System.out.println("B " + time);
                    break;
                } else if (bHealth <= 0) {
                    System.out.println("A " + time);
                    break;
                }
            }
        }
    }

    static class cannon {
        int type, onTime, chargeTime, damage, coolDown, coolDownTimer, chargeTimer;

        cannon(int type, int onTime, int chargeTime,
               int damage, int coolDown, int coolDownTimer, int chargeTimer) {
            this.type = type;
            this.onTime = onTime;
            this.chargeTime = chargeTime;
            this.damage = damage;
            this.coolDown = coolDown;
            this.coolDownTimer = coolDownTimer;
            this.chargeTimer = chargeTimer;
        }
    }

//    for (cannon c : aCannons) {
//        if (time >= c.onTime) {
//            if (c.chargeTimer >= c.chargeTime) {
//                c.chargeTimer = 0;
//                c.coolDownTimer = 0;
//                if (c.type == 2)
//                    aType2Shot = true;
//                aTotalDamage += c.damage;
//            } else {
//                if (c.coolDownTimer >= c.coolDown)
//                    c.chargeTimer += 1;
//                else
//                    c.coolDownTimer += 1;
//            }
//        }
//    }
//                for (cannon c : bCannons) {
//        if (time >= c.onTime) {
//            if (c.chargeTimer >= c.chargeTime) {
//                c.chargeTimer = 0;
//                c.coolDownTimer = 0;
//                if (c.type == 2)
//                    bType2Shot = true;
//                bTotalDamage += c.damage;
//            } else {
//                if (c.coolDownTimer >= c.coolDown)
//                    c.chargeTimer += 1;
//                else
//                    c.coolDownTimer += 1;
//            }
//        }
//    }
}
