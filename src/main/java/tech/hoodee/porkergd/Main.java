package tech.hoodee.porkergd;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("小明", Position.EAST);
        Player player2 = new Player("小红", Position.NORTH);
        Player player3 = new Player("小刚", Position.WEST);
        Player player4 = new Player("小华", Position.SOUTH);

        Game game = new Game(new Player[]{player1, player2, player3, player4});
        // 开始一轮牌局
        game.startRound();
    }
}
