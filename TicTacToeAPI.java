import spark.Spark.*;

public class TicTacToeAPI {
    public static void main(String[] args) {
        port(4567);
        
        get("/move/:index/:player", (req, res) -> {
            int index = Integer.parseInt(req.params(":index"));
            String player = req.params(":player");
            return "Move registered at " + index + " by Player " + player;
        });
        
        get("/reset", (req, res) -> "Game reset!");
    }
}
