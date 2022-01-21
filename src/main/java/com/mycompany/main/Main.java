package com.mycompany.main;
import com.mycompany.modelo.Mascota;
import com.mycompany.modelo.Duenio;
import com.mycompany.modelo.Ciudad;
import com.mycompany.modelo.Concurso;
import com.mycompany.modelo.Auspiciante;
import com.mycompany.modelo.DirigidoA;
import static com.mycompany.modelo.DirigidoA.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    //metodo para crear un concurso nuevo
     public static void crearConcurso(ArrayList<Auspiciante> listaAuspiciantes, ArrayList<Concurso> listaConcursos, ArrayList<Ciudad> listaCiudad){
        //se ingresan datos
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Ingresando datos de nuevo concurso");
                    System.out.println("Ingresar los siguientes datos:\n"
                            + "Nombre: " );
                    String n = sc.nextLine();
                    System.out.println("Fecha del evento (Ingresar en formato (yyyy-mm-dd)): " );
                    LocalDate fE = LocalDate.parse(sc.nextLine());
                    System.out.println();
                    System.out.println("Hora del evento: " );
                    String hE = sc.nextLine();
                    System.out.println("Fecha de Inicio de inscripcion (Ingresar en formato (yyyy-mm-dd)): " );
                    LocalDate fII = LocalDate.parse(sc.nextLine());
                    System.out.println("Fecha de Cierre de inscripcion (Ingresar en formato (yyyy-mm-dd)): " );
                    LocalDate fCI = LocalDate.parse(sc.nextLine());
                    ///ciudad
                    System.out.println("Ciudades registradas");//se muestran las ciudades existentes
                        int i=1;//contador -->index para seleccionar/escoger ciudad
                        for (Ciudad d : listaCiudad){//se itera y muestra cada ciudad
                            System.out.println(i +"."+ d.toString());
                            i++;}
                        //a partir de aqui se realiza un while para cuando se escoge un ciudad no existente
                        String seguir = "SI";//boolean de confirmacion
                        Ciudad ci = listaCiudad.get(0);
                            while("SI".equals(seguir)){
                            System.out.println("Escribir opción de ciudad:");
                            int nn = sc.nextInt();
                            if (listaCiudad.size()>= nn && nn>=0){//validacion si el numero esta dentro de las opciones
                                ci = listaCiudad.get(nn-1); //se obtiene la ciudad de la lista
                                System.out.println("Cambio realizado con exito.");
                                seguir = "NO";}    
                            else{System.out.println("Numero incorrecto, no existe la ciudad seleccionada.\n "
                                    + "¿Desea volver a ingresar un numero?[SI/NO]");
                                    seguir = sc.next();}}
                    //lugar
                    System.out.println("Lugar: " );
                    String lu = sc.next();
                    
                    //creacion de lista de auspiciantes
                    ArrayList<Auspiciante> aD = new ArrayList<>();
                    System.out.println("Ingrese cuantos auspiciantes se desean en el concurso: ");//ingresa numero de auspiciantes deseados
                    int numAu=sc.nextInt();
                    System.out.println("Auspiciantes registrados: ");//se muestran los auspiciantes existentes
                        int con=1;//contador -->index para seleccionar/escoger auspiciantes
                        for (Auspiciante d : listaAuspiciantes){//se itera y muestra cada auspiciante
                            System.out.println(con +"."+ d);
                            con++;}
                        
                    for(int e=0;e<numAu;e++){
                        System.out.println("Elegir e ingresar numero: " );//el usuario elige
                        int res = sc.nextInt();//se obtiene el int-->index
                        if (res>=0 && res<=listaAuspiciantes.size()){
                            Auspiciante a = listaAuspiciantes.get(res-1);//se escoge un auspiciante existente de la lista
                            aD.add(a);
                        }else {System.out.println("No existe tal auspiciante\n Ingrese de nuevo...");
                        e--;
                        }}
                     String p = Concurso.premioSegunAus(aD);//<--premios son seleccionados segun auspiciantes
                     ////////
                    
                    String cont = "SI";
                    DirigidoA d = TODOS;
                    while(cont.equals("SI")){//loop para repetir si el usuario se equivoco al ingresar opcion y quiere volver a intentar
                        System.out.println("Dirigido a (GATOS o PERROS o TODOS):" );
                        String dd = sc.next();
                    switch (dd) {
                      case "PERRO":
                         d = PERROS;
                         cont = "NO";
                          break;
                  //Definicion de Categoria de Mascota
                      case "GATOS":
                          d = GATOS;
                          cont = "NO";
                          break;
                       case "TODOS":
                          d = TODOS;
                          cont = "NO";
                          break;
                      default:
                          System.out.println("Ese dato no existe. \n ¿Desea intentar de nuevo? [SI/NO]");
                          cont = sc.nextLine();
                          break;
                  }}
                    System.out.println("Concurso creado.");
                    //se anaden los datos ingresados a la lista
                    Concurso c = new Concurso(n,fE,hE,fII,fCI,ci,lu,p,aD,d);
                    listaConcursos.add(c);
    }
     
     //metodo para crear o registrar un duenio nuevo
     public static void crearDuenio(ArrayList<Duenio> listaDuenio, ArrayList<Ciudad> listaCiudad){
        //se igresa cada dato de la clas duenio
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresando datos de un nuevo duenio");
        System.out.println("Ingresar los siguientes datos:");
        System.out.println("Cedula: " );
        String ced = sc.nextLine();
        System.out.println("Nombre: " );
        String n = sc.nextLine();
        System.out.println("Apellido: " );
        String a = sc.nextLine();
        System.out.println("Direccion: " );
        String dir = sc.nextLine();
        System.out.println("telefono: " );
        String tel = sc.next();
        ////ciudad
        System.out.println("Ciudades registrados: " );//se muestran las ciudades existentes
                        int i=0;//contador -->index para seleccionar/escoger ciudad
                        for (Ciudad d : listaCiudad){//se itera y muestra cada ciudad
                            System.out.println(i +"."+ d);
                            i++;}
        System.out.println("Elegir e ingresar numero: ");
                        int res0 = sc.nextInt();//se obtiene el int-->index
                        Ciudad ci = listaCiudad.get(res0);//se escoge una ciudad existente de la lista
        System.out.println("Email: " );
        String em = sc.next();
        Duenio d = new Duenio(ced, n, a, dir, tel, ci, em);//se crea el objeto duenio con la informacion ingresada
        listaDuenio.add(d);//se anade el nuevo duenio a la lista 
        System.out.println("Se ha creado con duenio con exito!!!");
        }
    
     //metodo para editar un duenio
     public static void editarDuenio(ArrayList<Duenio> listaDuenios, ArrayList<Ciudad> listaCiudad){
         String respon = "SI";//variable para saber si se repite la opcion si el numero de cedula es incorrecto
         while(respon.equals("SI")){//condicional de repetir segun la respuesta del usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingresar id (numero de cedula):");//se ingresa cedula
        String id = sc.nextLine();
        int existe = 0;//contador para saber cuantas veces no se encuentra el numero en la lista
        for (Duenio d : listaDuenios){//se recorre los elementos de la lista de duenios
            if (id.equals(d.getCedula())){//condicional cuando la cedula coincida con la informacion de la lista
                System.out.println("¿Cual dato desea modificar?: ");
                String dat = sc.nextLine();
                //switch-case para saber que tipo de dato cambiar
                //despues de cada "case" se cambiara la variable respon para salir del loop-->while
                if(dat!=null)switch(dat){
                    case "nombre":
                        System.out.println("Cambiando nombre a...:");
                        d.setNombre(sc.nextLine());
                        respon = "NO";
                        System.out.println("Cambio realizado con exito.");
                        break;
                    case "apellido":
                        System.out.println("Cambiando apellido a...:");
                        d.setApellido(sc.nextLine());
                        respon = "NO";
                        System.out.println("Cambio realizado con exito.");
                        break;
                    case "direccion":
                        System.out.println("Cambiando direccion a...:");
                        d.setDireccion(sc.nextLine());
                        respon = "NO";
                        System.out.println("Cambio realizado con exito.");
                        break;
                    case "telefono":
                        System.out.println("Cambiando telefono a...:");
                        d.setTelefono(sc.next());
                        respon = "NO";
                        System.out.println("Cambio realizado con exito.");
                        break;
                    case "ciudad":
                        System.out.println("Para cambiar ciudad, debe escoger de las siguientes opciones:");
                        int a = 1;//variable para indicar cada ciudad de la lista y para que el usuario pueda escoger una opcion 
                        
                        for(Ciudad c : listaCiudad){
                            System.out.println(a +"."+ c.toString());
                            a++;}
                        //a partir de aqui se realiza un while para cuando se escoge un ciudad no existente
                        boolean seguir = true;//boolean de confirmacion
                            while(seguir){
                            System.out.println("Escribir opción de ciudad:");
                            int n = sc.nextInt();
                            if (listaCiudad.size()>= n && n>=0){//validacion si el numero esta dentro de las opciones
                                Ciudad ci = listaCiudad.get(n-1); //se obtiene la ciudad de la lista                      
                                d.setCiudad(ci);//cambia la ciudad del duenio
                                respon = "NO";
                                System.out.println("Cambio realizado con exito.");
                                seguir = false;}
                            else{System.out.println("Numero incorrecto, no existe la ciudad seleccionada.");}}
                        break;

                    case "email":
                        System.out.println("Cambiando email a...:");
                        d.setEmail(sc.next());
                        respon = "NO";
                        System.out.println("Cambio realizado con exito.");
                        break;
                    default:
                        System.out.println("No existe ese tipo de dato.\n"+
                                "¿Desea volver a intentar? [SI/NO]");
                        respon = sc.nextLine();
                        break;
                    
                        }}else {existe++;}}
            if(existe == listaDuenios.size()){
                System.out.println("Lo sentimos, no se encuentra ese numero de cedula en el sistema.\n"+
                        "¿Desea volver a intentar? [SI/NO]");
                respon = sc.nextLine();
            }}
        }
     
        public static void crearMascota(ArrayList<Duenio> listaDuenio, ArrayList<Ciudad> listaCiudad,ArrayList<Mascota> listaMascota,ArrayList<Mascota> lisMascotaIns, boolean inscritoAntes){
            inscritoAntes = false;
            //Iniciazión  del Scanner
            Scanner sc = new Scanner(System.in);  
            //Pedido de ingreso de datos
            System.out.println("Ingrese el nombre de la mascota:");
            String nombrePet = sc.nextLine();//Nombre de mascota
            System.out.println("Escriba la categoria de concurso que participa(TODOS, GATO, PERRO)");//Categoria de mascota
            String participacionStr = sc.nextLine();

            DirigidoA participacionEnum;
            if (null == participacionStr){
                participacionEnum = DirigidoA.TODOS;
            }else switch (participacionStr) {
             case "PERRO":
                 participacionEnum = DirigidoA.PERROS;
                 break;
         //Definicion de Categoria de Mascota
             case "GATOS":
                 participacionEnum = DirigidoA.GATOS;
                 break;
             default:
                 participacionEnum = DirigidoA.TODOS;
                 break;
         }
          
          do{System.out.print("Ingrese el raza de la mascota:");
            //Ingreso de raza de mascota
            String raza = sc.nextLine();
            System.out.print("Fecha de nacimiento de la mascota:");
            //Ingreso de fecha de nacimiento
            LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());
             //Ingreso de foto de mascota
            System.out.print("Ingrese foto de la mascota:");
            String foto = sc.nextLine();
            //eleccion del duenio
            System.out.print("Duenios registradas");//se muestran los duenios  existentes
            int ii=0;//contador -->index para seleccionar/escoger duenio
            for (Duenio d : listaDuenio){//se itera y muestra cada duenio
                System.out.println(ii +"."+ d.toString());
                ii++;}
            System.out.print("Ingresar numero:");
            int res0 = sc.nextInt();//se obtiene el int-->index
            Duenio d0 = listaDuenio.get(res0);//se escoge un duenio existente de la lista
            Mascota mascotaP = new Mascota(nombrePet,participacionEnum, raza, fechaNacimiento, foto, d0);
             //Creación del objeto mascota
            
             
             for (Mascota m2:lisMascotaIns){
                 if(m2.equals(mascotaP)==false){
           
                     listaMascota.add(mascotaP);
                      //Se añade la mascota a la listaMascota
                 }else{
                     inscritoAntes= true;
                 }
             }
             
            }while(inscritoAntes==false);
            
           
        } public static void eliminarMascota(ArrayList<Mascota>listaMascota,ArrayList<Mascota>listaMascotaBan,ArrayList<Mascota>listaMascotaIns){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el codigo de la mascota");
            String cod = sc.nextLine();
            //Ingreso del codigo de la mascota
            for (Mascota m1:listaMascota){
                for (Mascota m1i:listaMascotaIns){
                    if (((m1.generarCodigo()).equals(cod))&&(m1i.equals(m1)==false)){
                        listaMascota.remove(m1);
                        listaMascotaBan.add(m1);
                        listaMascotaIns.add(m1);
                        }else {
                            listaMascota.remove(m1);
                            listaMascotaBan.add(m1);
                            }
                    }
                
                }
            }
        
     
     
    public static void main(String[] args){
        ArrayList<Concurso> listaConcursos = new ArrayList<>();
        ArrayList<Auspiciante> listaAuspiciantes = new ArrayList<>();
        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        ArrayList<Duenio> listaDuenios = new ArrayList<>();
        ArrayList<Ciudad> listaCiudad = new ArrayList<>();
        
         
         //se crean objetos de tipo ciudad, dadas en la consigna
         Ciudad ci1 = new Ciudad("Guayaquil","Guayas");
         Ciudad ci2 = new Ciudad("Quito","Pichincha");
         Ciudad ci3 = new Ciudad("Cuenca","Ambato");
         //se crean 3 auspiciantes
         
         Auspiciante au1 = new Auspiciante("DogChow","Complejo EKOPARK Torre 2., Av. Simón Bolívar y vía a Nayón EC170107 Quito ",
         "+593 2-223-2400", ci2,"dogchow@gmail.com","https://www.purina-latam.com/ec/dogchow/contacto");
         Auspiciante au2 = new Auspiciante("NutraPro","General Córdova No. 623 y Padre Solano Guayaquil - Ecuador", "(593 -4) 3703870", ci1,
                 "info@agripac.com.ec","https://agripac.com.ec/productos/nutrapro-cachorros-razas-medianas-ygrandes/");
         Auspiciante au3 = new Auspiciante("BuenCan","Av. Simón Bolivar", "+593 2-413-7400", ci2,
                 "buencan@gmail.com","https://www.buencan-latam.com/ec/buencan/contacto");
         //se crean 10 objetos de tipo duenio
         Duenio d1 = new Duenio("1200000000","Manuel","Sanchez",
                 "Sauces20---","0900000000",ci1,"manusa@yahoo.com");
         Duenio d2 = new Duenio("0990000000","Gioconda","Pilas",
                 "Alborada50---","0912345678",ci1,"mari50@yahoo.com");
         Duenio d3 = new Duenio("0999000000","Sabrina","Martinez",
                 "Sauces22---","0987654321",ci2,"sasa0920@yahoo.com");
         Duenio d4 = new Duenio("0999900000","Valeria","Molina",
                 "Tarazana1.0---","0900000000",ci3,"val@gmail.com");
         Duenio d5 = new Duenio("0999990000","Manuel","Vaca",
                 "Samborondon15---","0924681012",ci1,"vacaa1999@yahoo.com");
         Duenio d6 = new Duenio("0999999000","Pedro","Palma",
                 "Peñas8---","0913579111",ci2,"pedpalm@yahoo.com");
         Duenio d7 = new Duenio("0999999900","Maria","Martínez",
                 "Garzota-1---","0936912151",ci2,"marmarti@yahoo.com");
         Duenio d8 = new Duenio("0999999990","Carol","Santana",
                 "Samanes30---","0948121620",ci3,"carsantan@yahoo.com");
         Duenio d9 = new Duenio("0999999999","Miguel","Hurtado",
                 "Daule00---","0999999999",ci2,"miguhurta@yahoo.com");
         Duenio d10 = new Duenio("9999999999","Monica","Suarez",
                 "Florida15---","09510152025",ci2,"monsuar@yahoo.com");

         //se crean 10 objetos de tipo mascota
         Mascota m1 = new Mascota("Luka",PERROS,"french poodle",
                 LocalDate.parse("2012-05-01"),"fotito1",d1);
         Mascota m2 = new Mascota("Firulais",PERROS,"Sabari dog",
                 LocalDate.parse("2013-01-23"),"fotito2",d2);
         Mascota m3 = new Mascota("Lucy",GATOS,"Persian cat",
                 LocalDate.parse("2014-10-25"),"fotito3",d3);
         Mascota m4 = new Mascota("Celia",GATOS,"Bombay cat",
                 LocalDate.parse("2020-11-01"),"fotito4",d4);
         Mascota m5 = new Mascota("Wilson",GATOS,"Norwegian Forest cat",
                 LocalDate.parse("2021-05-02"),"fotito5",d5);
         Mascota m6 = new Mascota("Missa",GATOS,"Sphynx cat",
                 LocalDate.parse("2014-01-12"),"fotito6",d6);
         Mascota m7 = new Mascota("Copa",PERROS,"french poodle",
                 LocalDate.parse("2010-03-07"),"fotito7",d7);
         Mascota m8 = new Mascota("Nina",PERROS,"Rottweiler",
                 LocalDate.parse("2018-03-21"),"fotito8",d8);
         Mascota m9 = new Mascota("Sasha",PERROS,"St. Bernard",
                 LocalDate.parse("2015-02-05"),"fotito9",d9);
         Mascota m10 = new Mascota("Edgar",PERROS,"pug",
                 LocalDate.parse("2019-05-23"),"fotito10",d10);
         
         
         
        
        //se anade a la lista de mascotas
        listaMascotas.add(m1);
        listaMascotas.add(m2);
        listaMascotas.add(m3);
        listaMascotas.add(m4);
        listaMascotas.add(m5);
        listaMascotas.add(m6);
        listaMascotas.add(m7);
        listaMascotas.add(m8);
        listaMascotas.add(m9);
        listaMascotas.add(m10);
        
        //lista de ganadores de concurso pasado
        ArrayList<Mascota> listaGanadores= new ArrayList<>();//se crea una lista de los ganadores del concurso pasado
        //se anada las mascotas ganadoras
        listaGanadores.add(m1);
        listaGanadores.add(m2);
        listaGanadores.add(m3);
        //lista de mascotas inscritas en concurso pasado
        ArrayList<Mascota> lisMascotasIns= new ArrayList<>();
        lisMascotasIns.add(m1);
        lisMascotasIns.add(m2);
        lisMascotasIns.add(m3);
        lisMascotasIns.add(m4);
        lisMascotasIns.add(m5);
        
        //Lista de mascotas baneadas-vacia al no haberse eliminado por ahora ninguna mascota
        ArrayList<Mascota> lisMascotaBan = new ArrayList<>();//Se crea una lista de mascotas que se les niega la inscripción en los sgtes concursos
        
        //se anade a la lista de duenios
        listaDuenios.add(d1);
        listaDuenios.add(d2);
        listaDuenios.add(d3);
        listaDuenios.add(d4);
        listaDuenios.add(d5);
        listaDuenios.add(d6);
        listaDuenios.add(d7);
        listaDuenios.add(d8);
        listaDuenios.add(d9);
        listaDuenios.add(d10);
        //se anade a la lista de auspiciantes
        listaAuspiciantes.add(au1);
        listaAuspiciantes.add(au2);
        listaAuspiciantes.add(au3);
        //se anade a la lista de ciudades
        listaCiudad.add(ci1);
        listaCiudad.add(ci2);
        listaCiudad.add(ci3);
        
        //se crea 1 concurso pasado
         Concurso c1 = new Concurso("Perritos en Talento",LocalDate.parse("2019-05-04"),"11am",
                 LocalDate.parse("2019-04-14"),LocalDate.parse("2019-04-24"),ci1,
                 "Parque",Concurso.premioSegunAus(listaAuspiciantes),listaAuspiciantes,PERROS);
         
         //se crea 1 concurso vigente
         Concurso c2 = new Concurso("Perritos en Talento",LocalDate.parse("2019-05-04"),"2pm",
                 LocalDate.parse("2019-04-14"),LocalDate.parse("2019-04-24"),ci1,
                 "Estadio",Concurso.premioSegunAus(listaAuspiciantes),listaAuspiciantes,TODOS);
        //se anade a la lista de concursos
        listaConcursos.add(c1);
        listaConcursos.add(c2);
        
     ///////////////////////////////////////////////////////////////////////////
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenidos al proyecto de POO");
        boolean repetir = true;
        
        while (repetir){
        System.out.println("1. Administrar Concursos\n" +
                        "2. Administrar Dueños\n" +
                         "3. Administrar Mascotas");
    
        System.out.println("Seleccionar opcion: (ingresar numero)");

        String op = sc.nextLine();
        if (null != op)switch (op) {
            case "1":
                //Mostrar lista de concursos
                System.out.println("A continuacion se muestran los concursos");
                int no=0;//contador -->index para seleccionar/escoger concurso
                for(Concurso co : listaConcursos){
                    System.out.println(no+"."+co.toString());
                    no++;
                }
                
                System.out.println("Seleccionar opcion: (ingresar numero)\n"
                                        + "1. Crear concurso\n" +
                                   "2. Inscribir participante\n" +
                                    "3. Regresar al menú principal");
                System.out.println("Seleccionar opcion: (ingresar numero)");
                
                 String op1 = sc.nextLine();
                 if(null != op1)switch (op1) {
                case "1":
                    //crear un concurso nuevo
                    crearConcurso(listaAuspiciantes, listaConcursos, listaCiudad);
                   
                    repetir = false;//se cambia el boolean para salir del loop
                    break;
         
                case "2":
                    
                    //se pregunta en cual concurso se crea el participante
                    System.out.println("¿en cual concurso se desea inscribir?: (Ingresar numero)");
                    int re = sc.nextInt();
                    
                    LocalDate fecha_hoy = LocalDate.now();//variable de fecha 
                    Boolean estado;//boolean para verificar si el concurso esta abierto o cerrrado para inscripciones
                    for (Concurso co :listaConcursos ){
                        //se verifica con la fecha actual fecha_hoy
                        //si la fecha actual esta entre la fecha de inicio y cierre de inscripcion el boolean de verificacion es true
                         //caso contrario el boolean es false
                        estado = co.getFechaCierreDeInscripcion().isAfter(fecha_hoy)&&
                                co.getFechaInicioDeInscripcion().isBefore(fecha_hoy); 
                        //se llama al metodo inscribir participante segun el concurso ingresado
                        if (listaConcursos.get(re-1).equals(co)){//verificar cuando en concurso ingresado y el de la lista coincidan
                             co.inscribirParticipante(listaMascotas,lisMascotasIns, listaGanadores, listaDuenios, estado);}}
                    
                     
                     repetir = false;//se cambia el boolean para salir del loop
                    break;
                    
                case "3"://no se hace nada--> el loop continua
                    break;
                default:
                    break;
            }
                break;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            case "2":
                //administrar duenio
                
                System.out.println("4. Crear dueño\n" +
                                "5. Editar dueño\n" +
                                "6. Regresar al menú principal");

                System.out.println("Seleccionar opcion: (ingresar numero)");
                String op2 = sc.nextLine();
                 if(null != op2)switch (op2) {
                case "4":
                //se llama al metodo para crear duenio
                crearDuenio(listaDuenios, listaCiudad);
                repetir = false;//se cambia el boolean para salir del loop
                break;
                case "5":
                //se llama al metodo para editar duenio
                editarDuenio(listaDuenios, listaCiudad);
                repetir = false;//se cambia el boolean para salir del loop
                break;
                case "6":
                //no se realiza nada--> se vuelve al menu principal por loop
                break;
                 
                default:
                break;}
                 break;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////                
            case "3":
                //administrar mascotas
                
                System.out.println("7. Crear mascota\n" +
                                    "8. Eliminar mascota\n" +
                                    "9. Regresar al menú principal");
                System.out.println("Seleccionar opcion: (ingresar numero)");
                String op3 = sc.nextLine();
                 if(null != op3)switch (op3) {
                case "7":
                //se llama al metodo para crear mascota
                crearMascota(listaDuenios, listaCiudad, listaMascotas,lisMascotasIns,false);
                repetir = false;//se cambia el boolean para salir del loop
                break;
                case "8":
                //se llama al metodo para editar duenio
    
                eliminarMascota( listaMascotas, lisMascotasIns,lisMascotaBan);
                repetir = false;//se cambia el boolean para salir del loop
                break;
                case "9":
                //no se realiza nada--> se vuelve al menu principal por loop
                break;
                 
                default:
                    break;}
                 
                break;
            default:
                break;
        }}
    }}   

