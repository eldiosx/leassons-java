import java.util.ArrayList;

public class PilasHanoi extends ArrayList<Integer> {
   public void meter(int pieza) {
      if (pieza<get(size()-1)) {
         add(pieza);
      }
   }
   public int sacar() {
      return remove(size()-1);
   }
   public int cima() {
      return get(size()-1);
   }
}
