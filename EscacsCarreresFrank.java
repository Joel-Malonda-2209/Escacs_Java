// Fet per : Frank Carreres Catalá
package escacscarreresfrank;

public class EscacsCarreresFrank {
    
    // FUNCIÓ esPeça :
    private static boolean esPeça(char peça) {
        return peça == 'D' || peça == 'R' || peça == 'A' || peça == 'C' || peça == 'T';
    }

    public static void main(String[] args) {
        
        boolean continuarJugant = true;

        System.out.println("");
        System.out.println("_____________________________________________");
        System.out.println("                                             ");
        System.out.println("               TAULER D' ESCACS              ");
        System.out.println("_____________________________________________");

        System.out.println("");

        int altTauler = 0;
        int ampleTauler = 0;
        char tauler[][];


        System.out.println("");
        altTauler = Teclat.lligInt("- Dis-me l'alt del tauler", 5,9);

        System.out.println("");
        ampleTauler = Teclat.lligInt("- Dis-me l'ample del tauler",5,9);

        System.out.println("");
        System.out.println("· El tauler de " + altTauler + "X" + ampleTauler + " s'ha creat!");
        
        // DECLARACIÓ DE LA MATRIU
        tauler = new char[altTauler+1][ampleTauler+1];
        
        // OMPLIR MATRIU:
        for (int fila = 1; fila < tauler.length; fila++) {
            for (int columna = 1; columna < tauler[0].length; columna++) {
                tauler[fila][columna] = '-';
            }
        }

        int opcioElegida = 0;

        while (continuarJugant == true) {

            System.out.println("");
            System.out.println("_____________________________________________");
            System.out.println("                                             ");
            System.out.println("            - MENÚ D' ESCACS                 ");
            System.out.println("                                             ");
            System.out.println("           1.- Posar una peça                ");
            System.out.println("           2.- Mostrar els moviments         ");
            System.out.println("           3.- Esborrar moviments            ");
            System.out.println("           4.- Esborrar tauler               ");
            System.out.println("           5.- Eixir                         ");
            System.out.println("_____________________________________________");
            System.out.println("                                             ");

            // TAULER __________________________________________________________
            
            // NÚMEROS DE FORA
            System.out.print("           ");

            for (int col = 1; col <= ampleTauler; col++) {
                System.out.print("  " + col);
            }
            
            System.out.println("");
            
            // NÚMEROS DE DINS
            for (int fila = 1; fila < tauler.length; fila++) {
                System.out.print("          " + (fila ));
                
                for (int columna = 1; columna < tauler[0].length; columna++) {
                    System.out.print("  " + tauler[fila][columna]);
                }
                
                System.out.print("  " + (fila));
                System.out.println("");
            }
            
            // NÚMEROS DE FORA
            System.out.print("           ");
            
            for (int col = 1; col <= ampleTauler; col++) {
                System.out.print("  " + col);
            }
            
            //__________________________________________________________________
            
            System.out.println("");
            System.out.println("_____________________________________________");
            System.out.println("                                             ");
            System.out.println("");
            System.out.println("");
            opcioElegida = Teclat.lligInt("· Quina opcio vols elegir? -->  ");
            System.out.println("");        
        
            
            char MOVIMENT = '*';
            switch (opcioElegida) {
                

                
                case 1: // Opció 1 : Posar una peça
                    
                    System.out.println("/ T = TORRE / D = DAMA / R = REI / A = ALFIL / C = CAVALL / ");
                    System.out.println("");
                    char peçaEscollida = Teclat.lligChar("- Quina peça vols escollir? --> ", "rcatd");
                    System.out.println("");
                            
                    int filaEscollida = Teclat.lligInt("- En quina fila vols colocar la peça? (" + peçaEscollida + ") --> ",1,ampleTauler);                        
                    int columnaEscollida = Teclat.lligInt("- En quina columna vols colocar la peça? (" + peçaEscollida + ") --> ",1,altTauler);
                    
                    if (esPeça(tauler[filaEscollida][columnaEscollida]))
                        System.out.println("· En aquesta possició ja hi ha una peça...");
                    else{
                        tauler[filaEscollida ][columnaEscollida ] = peçaEscollida;                        
                    }                            
                break;
                
                
                case 2: //Opció 2 : Mostrar els moviments
                    
                    int filaPeça = Teclat.lligInt("- Dis-me en quina fila es troba la peça " ,1 ,ampleTauler );
                    int colPeça = Teclat.lligInt("- Dis-me en quina columna es troba la peça ",1 ,altTauler);
                    
                    switch (tauler[filaPeça][colPeça]){
                        
                        // MOVIMENTS TORRE
                        case 'T':
                            
                            // MOVIMENT DRETA (+)      
                            for (int c = (colPeça + 1); c <= ampleTauler; c++) {
                            
                                if (esPeça(tauler[filaPeça][c])){
                                    break;
                                }
                                
                                else {
                                    tauler[filaPeça][c] = MOVIMENT;
                                }
                            }
                            
                            //MOVIMENT ESQUERRA (-)
                            for (int c = (colPeça - 1); c >= 1 ; c--) {
                                
                                if (esPeça(tauler[filaPeça][c])){
                                   break;
                                }
                                else {
                                    tauler[filaPeça][c] = MOVIMENT;
                                }                                
                            }
                            
                            // MOVIMENT BAIX (+)
                            for (int f = (filaPeça + 1); f <= altTauler; f++) {
                                
                                if (esPeça(tauler[f][colPeça])){
                                    break;
                                }
                                else {
                                    tauler[f][colPeça] = MOVIMENT; 
                                }   
                            }
                 
                            // MOVIMENT DALT (-)                            
                            for (int f = (filaPeça - 1); f >= 1; f--) {
                                
                                if (esPeça(tauler[f][colPeça])){
                                    break;
                                }
                                else {
                                    tauler[f][colPeça] = MOVIMENT; 
                                }                                
                            }
                            
                        break;
                        
                        // MOVIMENTS REI
                        case 'R':
                            
                            //MOVIMENT DE DALT (-) 
                            try{
                                if (!esPeça(tauler[filaPeça - 1][colPeça])){
                                    tauler[filaPeça - 1][colPeça] = MOVIMENT;
                                }
                            }
                            catch (Exception e){  
                            }

                            //MOVIMENT DE BAIX (+)
                            try{
                                if (!esPeça(tauler[filaPeça + 1][colPeça])){
                                    tauler[filaPeça + 1][colPeça] = MOVIMENT;
                                }
                            }
                            catch (Exception e){  
                            }
                            
                            //MOVIMENT ESQUERRA (-)
                            try{
                                if (!esPeça(tauler[filaPeça][colPeça - 1])){
                                    tauler[filaPeça][colPeça - 1] = MOVIMENT;   
                                }    
                            }    
                            catch (Exception e){
                            }

                            // MOVIMENT DRETA (+)
                            try {
                                if (!esPeça(tauler[filaPeça][colPeça + 1])){
                                    tauler[filaPeça][colPeça + 1] = MOVIMENT;
                                }
                            }
                            catch (Exception e){  
                            }
                            
                            // 4 MOVIMENTS RESTANTS :
                            
                            // PART DE DALT                            
                            try {
                                if (!esPeça(tauler[filaPeça - 1][colPeça + 1])){
                                    tauler[filaPeça - 1][colPeça + 1] = MOVIMENT;
                                }                                  
                            }
                            catch (Exception e){    
                            }
                            
                            try{
                                if (!esPeça(tauler[filaPeça - 1][colPeça - 1])){
                                    tauler[filaPeça - 1][colPeça - 1] = MOVIMENT;
                                }                                     
                            }
                            catch (Exception e){    
                            }

                            // PART DE BAIX                           
                            try{
                                if (!esPeça(tauler[filaPeça + 1][colPeça + 1])){
                                    tauler[filaPeça + 1][colPeça + 1] = MOVIMENT;
                                }                                    
                            }
                            catch (Exception e) {  
                            }
                            
                            try{
                                if (!esPeça(tauler[filaPeça + 1][colPeça - 1])){
                                    tauler[filaPeça + 1][colPeça - 1] = MOVIMENT;
                                }                                  
                            }
                            catch (Exception e){
                            }
                            
                        break;   
                        
                        // MOVIMENTS CAVALL
                        case 'C':
                            
                            // PART DE DALT (DRETA)
                            try{
                                if (!esPeça(tauler[filaPeça - 1][colPeça + 2])){
                                    tauler[filaPeça - 1][colPeça + 2] = MOVIMENT;
                                }
                            }
                            catch(Exception e){
                            }
                            
                            try{
                                if (!esPeça(tauler[filaPeça - 2][colPeça + 1])){  
                                    tauler[filaPeça - 2][colPeça + 1] = MOVIMENT;
                                }
                            }
                            catch (Exception e){
                            }
                            
                            // PART DE DALT (ESQUERRA)
                            try{
                                if (!esPeça(tauler[filaPeça - 1][colPeça - 2])){  
                                    tauler[filaPeça - 1][colPeça - 2] = MOVIMENT;
                                }
                            }
                            catch(Exception e){
                            }
                            
                            try{
                                if (!esPeça(tauler[filaPeça - 2][colPeça - 1] = MOVIMENT)){
                                    tauler[filaPeça - 1][colPeça - 2] = MOVIMENT;
                                }
                            }
                            catch(Exception e){
                            }
                            
                            // PART DE BAIX (DRETA)
                            try{
                                if (!esPeça(tauler[filaPeça + 1][colPeça + 2] = MOVIMENT)){
                                    tauler[filaPeça + 1][colPeça + 2] = MOVIMENT;
                                }
                            }
                            catch (Exception e){    
                            }
                            
                            try{
                                if (!esPeça(tauler[filaPeça + 2][colPeça + 1])){   
                                    tauler[filaPeça + 2][colPeça + 1] = MOVIMENT;
                                }
                            }
                            catch(Exception e){
                            }
                            
                            // PART DE BAIX (ESQUERRA)
                            try{
                                if (!esPeça(tauler[filaPeça + 1][colPeça - 2])){  
                                    tauler[filaPeça + 1][colPeça - 2] = MOVIMENT;
                                }
                            }
                            catch(Exception e){ 
                            }
                            
                            try{
                                if (!esPeça(tauler[filaPeça + 2][colPeça - 1])){
                                    tauler[filaPeça + 2][colPeça - 1] = MOVIMENT;
                                }
                            }
                            catch(Exception e){   
                            }
                            
                        break;    
                        
                        // MOVIMENTS ÁLFIL
                        case 'A':    
                            
                            // PART DE DALT (ESQUERRA)
                            for (int f = (filaPeça - 1) , c = (colPeça - 1) ; c >= 1 && f >=1 ; c-- , f--){
                                if (esPeça(tauler[f][c])){
                                    break;
                                }
                                else{
                                    tauler[f][c] = MOVIMENT;    
                                }
                            }
                            
                            // PART DE DALT (DRETA)
                            for (int f = (filaPeça - 1) , c = (colPeça + 1) ; c <= ampleTauler && f >=1 ; c++ , f--){
                                if (esPeça(tauler[f][c])){
                                    break;
                                }
                                else{
                                    tauler[f][c] = MOVIMENT;
                                }
                            }
                            
                            // PART DE BAIX (ESQUERRA)
                            for (int f = (filaPeça + 1) , c = (colPeça - 1) ; c >= 1 && f <= altTauler ; c-- , f++){
                                if (esPeça(tauler[f][c])){
                                    break;                                    
                                }
                                else{
                                    tauler[f][c] = MOVIMENT; 
                                }
                            }
                            
                            // PART DE BAIX (DRETA)
                            for (int f = (filaPeça + 1) , c = (colPeça + 1) ; c <= ampleTauler && f <= altTauler ; c++ , f++){
                                if (esPeça(tauler[f][c])){
                                    break;
                                }
                                else{
                                    tauler[f][c] = MOVIMENT;
                                }
                            }
                            
                        break;
                        
                        // MOVIMENTS DAMA (ÁLFIL + TORRE)
                        case 'D':
                            
                            // MOVIMENTS DEL ÁLFIL ____________________________________________________________________________
                            
                            // PART DE DALT (ESQUERRA)
                            for (int f = (filaPeça - 1) , c = (colPeça - 1) ; c >= 1 && f >=1 ; c-- , f--){
                                if (esPeça(tauler[f][c])){
                                    break;
                                }
                                else{
                                    tauler[f][c] = MOVIMENT;    
                                }
                            }
                            
                            // PART DE DALT (DRETA)
                            for (int f = (filaPeça - 1) , c = (colPeça + 1) ; c <= ampleTauler && f >=1 ; c++ , f--){
                                if (esPeça(tauler[f][c])){
                                    break;
                                }
                                else{
                                    tauler[f][c] = MOVIMENT;
                                }
                            }
                            
                            // PART DE BAIX (ESQUERRA)
                            for (int f = (filaPeça + 1) , c = (colPeça - 1) ; c >= 1 && f <= altTauler ; c-- , f++){
                                if (esPeça(tauler[f][c])){
                                    break;                                    
                                }
                                else{
                                    tauler[f][c] = MOVIMENT; 
                                }
                            }
                            
                            // PART DE BAIX (DRETA)
                            for (int f = (filaPeça + 1) , c = (colPeça + 1) ; c <= ampleTauler && f <= altTauler ; c++ , f++){
                                if (esPeça(tauler[f][c])){
                                    break;
                                }
                                else{
                                    tauler[f][c] = MOVIMENT;
                                }
                            } 
                            
                            //___________________________________________________________________________________________________

                            // MOVIMENTS DE LA TORRE ____________________________________________________________________________
                           
                            for (int c = (colPeça + 1); c <= ampleTauler; c++) {
                                if (esPeça(tauler[filaPeça][c])){
                                    break;
                                }
                                else {
                                    tauler[filaPeça][c] = MOVIMENT;
                                }
                            }
                            
                            //MOVIMENT ESQUERRA (-)
                            for (int c = (colPeça - 1); c >= 1 ; c--) {
                                if (esPeça(tauler[filaPeça][c])){
                                   break;
                                }
                                else {
                                    tauler[filaPeça][c] = MOVIMENT;
                                }                                
                            }
                            
                            // MOVIMENT BAIX (+)
                            for (int f = (filaPeça + 1); f <= altTauler; f++) {                                
                                if (esPeça(tauler[f][colPeça])){
                                    break;
                                }
                                else {
                                    tauler[f][colPeça] = MOVIMENT; 
                                }   
                            }
                 
                            // MOVIMENT DALT (-)                            
                            for (int f = (filaPeça - 1); f >= 1; f--) {
                                if (esPeça(tauler[f][colPeça])){
                                    break;
                                }
                                else {
                                    tauler[f][colPeça] = MOVIMENT; 
                                }                                
                            }
                            
                        break;
                    }
                    
                break;
                    
                    
                case 3: // Opció 3 : Esborrar moviments
                    
                    int movsEsborrats = 0;
                    
                    for (int fila = 1; fila < tauler.length; fila++) {
                        for (int columna = 1; columna < tauler[0].length; columna++) {
                            if(tauler[fila][columna] == MOVIMENT){
                               tauler[fila][columna] = '-';
                               movsEsborrats += 1;
                            }
                        }
                    }
                    
                    System.out.println("· S'han esborrat " + movsEsborrats + " moviments.");
                    
                break;    
 
                case 4: // Opció 4 : Esborrar tauler
                    
                    for (int fila = 0; fila < tauler.length; fila++) {

                        for (int columna = 0; columna < tauler.length; columna++) {

                            tauler[fila][columna] = '-';
                        }
                    }
                    
                break;
                
                case 5: // Opció 5 : Eixir
                    
                    char respostaEixida = Teclat.lligChar("- Vols eixir del programa? (S,s/N,n)");

                        while (respostaEixida != 'N' && respostaEixida != 'n' && respostaEixida != 's' && respostaEixida != 'S') {

                            System.out.println("- Aquest valor no em val, introdueix un nou");
                            System.out.println("");
                            respostaEixida = Teclat.lligChar("- Vols eixir del programa? (S,s/N,n)");
                            System.out.println("");
                        }

                        continuarJugant = !(respostaEixida == 'S' || respostaEixida == 's');                   
                break;
                
            }
        }  
    }
}