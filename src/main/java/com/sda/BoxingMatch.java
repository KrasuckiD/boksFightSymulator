package com.sda;

import java.util.Random;

public class BoxingMatch implements IFight {
    private IFighter boxer1;
    private IFighter boxer2;

    public BoxingMatch(IFighter boxer1, IFighter boxer2) {
        this.boxer1 = boxer1;
        this.boxer2 = boxer2;
    }

    @Override
    public void fight() {
        IFighter first;
        IFighter second;

        Random random = new Random();
        if (random.nextInt() % 2 == 0) {
            first = boxer1;
            second = boxer2;
        } else {
            first = boxer2;
            second = boxer1;
        }

        boolean isFightOver = false;
        IFighter winner = null;
        while (!isFightOver) {
            AttackType attack_f1 = first.getAttackAction();
            BlockType blockType_f2 = second.getBlockAction();
            HitOutcome hitOutcome = isHitSuccessfull(attack_f1, blockType_f2);
            checkDamage(first, second, hitOutcome);
            if (!second.isAlive()) {
                winner = first;
                break;
            }

            System.out.println("");
            System.out.println(first.getName() + " zadaje cios " + attack_f1);
            System.out.println(second.getName() + " używa " + blockType_f2);
            System.out.println(second.getName() + " ma wciąż " + second.getHp() + " HP");

            AttackType attack_f2 = second.getAttackAction();
            BlockType blockType_f1 = first.getBlockAction();
            hitOutcome = isHitSuccessfull(attack_f2, blockType_f1);
            checkDamage(second, first, hitOutcome);
            if (!first.isAlive()) {
                winner = second;
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
            System.out.println(second.getName() + " zadaje cios " + attack_f2);
            System.out.println(first.getName() + " uzywa " + blockType_f1);
            System.out.println(first.getName() + " ma wciąż " + first.getHp() + " HP");
        }
        System.out.println("Zwycięzcą jest " + winner.getName());
    }

    private void checkDamage(IFighter first, IFighter second, HitOutcome hitOutcome) {
        if (HitOutcome.FULL.equals(hitOutcome)) {
            second.decreaseHp(3);
        } else if (HitOutcome.PARTIAL.equals(hitOutcome)) {
            second.decreaseHp(1);
        } else if (HitOutcome.DODGED.equals(hitOutcome)) {
            second.decreaseHp(0);
        }
        }


    private HitOutcome isHitSuccessfull(AttackType attack_f1, BlockType block_f2) {
        Random random = new Random();
        int damage = random.nextInt(100);
        if (AttackType.HOOK.equals(attack_f1) && BlockType.LOW.equals(block_f2)) {
            return HitOutcome.FULL;
        } else if (AttackType.JAB.equals(attack_f1) && BlockType.LOW.equals(block_f2)) {
            return HitOutcome.FULL;
        } else if (AttackType.UPPERCUT.equals(attack_f1) && BlockType.LOW.equals(block_f2)){
          return HitOutcome.FULL;
        }

        else if (AttackType.HOOK.equals(attack_f1) && BlockType.HIGH.equals(block_f2)) {
            return HitOutcome.PARTIAL;
        } else if (AttackType.JAB.equals(attack_f1) && BlockType.HIGH.equals(block_f2)){
            return HitOutcome.PARTIAL;
        } else if (AttackType.UPPERCUT.equals(attack_f1) && BlockType.HIGH.equals(block_f2)) {
            return HitOutcome.PARTIAL;
        }

        else if (AttackType.HOOK.equals(attack_f1) && BlockType.DODGE.equals(block_f2)) {
            return HitOutcome.DODGED;
        } else if (AttackType.JAB.equals(attack_f1) && BlockType.DODGE.equals(block_f2)){
            return HitOutcome.DODGED;
        } else  {
            return HitOutcome.DODGED;
        }
    }
}
