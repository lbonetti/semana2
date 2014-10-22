/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.sql.SQLException;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Nit0
 */
public class Manipulacao {
    private static int totalVotos;
    private static double nota1;
    private static double nota2;
    private static double nota3;
    private static double nota4;
    private static double nota5;
    private static double satisfeito;
    private static double insatisfeito;
    private static String sugestao;
    private static String nome;
    
    public Manipulacao()
    {
    }  
    
    public void setTotalVotos(int totalVotos) 
    { 
        this.totalVotos = totalVotos; 
    }
    
    public void setnota1(double nota1) 
    { 
        this.nota1 = nota1; 
        double nota  = this.nota1;
    }
    
    public void setnota2(double nota2) 
    {         
        this.nota2 = nota2; 
    }
    
    public void setnota3(double nota3) 
    { 
        this.nota3 = nota3; 
    }
    
    public void setnota4(double nota4) 
    { 
        this.nota4 = nota4; 
    }
    
    public void setnota5(double nota5) 
    { 
        this.nota5 = nota5; 
    }
    
    public void setsatisfeito(double satisfeito) 
    { 
        this.satisfeito = satisfeito; 
    }
    
    public void setSugestao(String sugestao) 
    { 
        this.sugestao = sugestao; 
    }
    
    public void setNome(String nome) 
    { 
        this.nome = nome; 
    }
    
    public void setinsatisfeito(double insatisfeito) 
    { 
        this.insatisfeito = insatisfeito; 
    }
    
    public double getnota1() 
    { 
        return nota1; 
    }
    
    public double getnota2() 
    { 
        return nota2; 
    }
    
    public double getnota3() 
    { 
        return nota3; 
    }
    
   public double getnota4() 
    { 
        return nota4; 
    }
    
    public double getnota5() 
    { 
        return nota5; 
    }
    
    public String getSugestao() 
    { 
        return sugestao; 
    }
    
    public String getNome() 
    { 
        return nome; 
    }
    
    public double getsatisfeito() 
    { 
        return satisfeito; 
    }
    
    public double getinsatisfeito() 
    { 
        return insatisfeito; 
    }
    
    public void calculoNotas() throws ClassNotFoundException, SQLException
    {
        Banco bd = new Banco();
        bd.consultarQuantidadeVotos();
        bd.consultarNota1();
        bd.consultarNota2();
        bd.consultarNota3();
        bd.consultarNota4();
        bd.consultarNota5();
       if(nota1 > 0)
        nota1 = (nota1/totalVotos)*100;
       if(nota2 > 0)
        nota2 = (nota2/totalVotos)*100;
       if(nota3 > 0)
        nota3 = (nota3/totalVotos)*100;
       if(nota4 > 0)
        nota4 = (nota4/totalVotos)*100;
       if(nota5 > 0)
        nota5 = (nota5/totalVotos)*100;
    }
    
    public void calculoSatisfacao() throws ClassNotFoundException, SQLException
    { 
        Banco bd = new Banco();
        bd.consultarQuantidadeVotos();
        bd.consultarSatisfeto();
        bd.consultarInsatisfeto();
        satisfeito = (satisfeito/totalVotos)*100;
        insatisfeito = (insatisfeito/totalVotos)*100;
    }
    
    public void manipulaTempo() throws ClassNotFoundException, SQLException, InterruptedException, Throwable
    { 
        boolean gira = true;
        int x = 2;
        while (gira = true)
        {
            if (x == 2) 
            { // 30 segundos
                Banco bd = new Banco();
                bd.consultarQuantidadeVotos();
                BarChart3D chart = new BarChart3D("Semana da Pesquisa Científica", "Pesquisa de notas atribuida a semana ( "+this.totalVotos+" votos ).");
                chart.pack( );
                RefineryUtilities.centerFrameOnScreen( chart );
                chart.setVisible( true );               
                Thread.sleep(60000);
                chart.dispose();
                x = 1; 
            } 
            else if (x == 1)
            {                
                PieChart demo = new PieChart("Semana da Pesquisa Científica.", "Pesquisa de satisfação ( "+this.totalVotos+" votos ).");
                demo.pack();
                demo.setVisible(true);
                Thread.sleep(60000);
                demo.dispose();
                x = 3; 
            }
            else if (x == 3)
            {
                FormSugestao f = new FormSugestao();
                f.setVisible(true);
                Thread.sleep(60000);
                f.dispose();
                x=2;
            }
        } 
    }
    
}
