import javax.swing.JOptionPane;

public class Carro {

  // criação de atributos
  public String marca;
  public int ano;
  private int marcha = 0;
  public boolean ligado;
  public int velocidade;
  public boolean freio = true;


  // métodos
  public void ligar(){

    if(this.ligado == false)  {
      this.ligado = true;
      JOptionPane.showMessageDialog(null, "Carro ligado.");
    }  else {
      System.out.println("O carro já está ligado");
    } 
  }
  
  public void desligar(){

    if (this.ligado == true) {
      this.ligado = false;
      System.out.println("Carro desligado.");
    }  else {
      System.out.println("O carro não está ligado");
    }
    
  }
  
  public void trocarMarcha(){
    ++this.marcha;
    System.out.println("Marcha trocada.");
  }

  public void acelerar(int velocidade){
    if(this.ligado == true ) {
      if (this.freio == false) {
        
      
      if (this.marcha == 0) {
        JOptionPane.showMessageDialog(null, "Está em ponto morto");
      }

      if (this.marcha == 1) {
        if (velocidade <= 30) {
          this.velocidade = velocidade;
          System.out.println("A velocidade agora é " + velocidade);
        } else {
          System.err.println("Na primeira a velocidade máxima é 30");
        }
      }

      if (this.marcha == 2) {
        if (velocidade <= 50) {
          this.velocidade = velocidade;
          System.out.println("A velocidade agora é " + velocidade);
        } else {
          System.err.println("Na segunda a velocidade máxima é 50");
        }
      }

      if (this.marcha == 3) {
        if (velocidade <= 70) {
          this.velocidade = velocidade;
          System.out.println("A velocidade agora é " + velocidade);
        } else {
          System.err.println("Na terceira a velocidade máxima é 70");
        }
      }
      } else {
        System.err.println("É preciso desativar o freio antes");
      }
    } else {
      System.out.println("O carro não está ligado");
    }
  }
}