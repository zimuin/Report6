package jp.ac.uryukyu.ie.e205736;

/**プレイヤーたちが所持するカードをクラスとして用意しました */

class Card {
    private int cardNumber;//カードに書かれている数字
    


    Card(int cardNumber){
        this.cardNumber = cardNumber;
        }

    /**カードに書かれている数字を返すためのメソッド
      * @return cardNumber
      */
        public int getCardNumber(){
            return cardNumber;
        }

       
    }

