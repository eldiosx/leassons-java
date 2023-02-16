import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

public class PilaOrdenada {
   ArrayList<Integer> lista = new ArrayList<>();
   void meter(int pieza) {
      if (pieza>lista.get(lista.size()-1)) {
         return;
      } else {
         lista.add(pieza);
      }
      
   }
   int sacar() {
      return lista.remove(lista.size()-1);
   }
   int cima() {
      return lista.get(lista.size()-1);
   }
}