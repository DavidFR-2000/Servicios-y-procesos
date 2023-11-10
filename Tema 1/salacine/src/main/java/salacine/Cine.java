package salacine;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Cine {
    //RECOLOCA LOS METODOS Y HAZ LA PLANTILLA BASANDO EN ESTO
    //PARA QUE EL AÑO QUE VIENE QUEDE MEJOR
    private ArrayList<Pelicula> lista_pelis;

    public Cine() {
        this.lista_pelis = new ArrayList<>();
    }

    public String visualizarPeliculas() {
        String res;

        if (this.lista_pelis.isEmpty()) {
            res = "No hay pelis todavía";
        } else {
            res = "";
            for (Pelicula p : this.lista_pelis) {
                res += p.toString();
            }
        }

        return res;

    }

    private Pelicula encontrarPeli(String titulo) {
        Pelicula buscado = null;
        Iterator<Pelicula> it = this.lista_pelis.iterator();

        while (it.hasNext() && buscado == null) {
            Pelicula p = it.next();
            if (p.getNombre().equals(titulo)) {
                buscado = p;
            }
        }

        return buscado;
    }

    public void añadirPelicula(String titulo, String genero, double recaudacion, int duracion) {

        if (encontrarPeli(titulo) != null) {
            System.out.println("Ya existe esa pelicula");
        } else {
            Pelicula nuevo = new Pelicula(titulo, genero, recaudacion, duracion);
            this.lista_pelis.add(nuevo);
        }
    }


    public void cargarTexto(String ruta) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea, titulo, genero;
            double recaudacion;
            int duracion;
            String[] partes;
            Pelicula p;
            this.lista_pelis.clear();
            while ((linea = br.readLine()) != null) {
                partes = linea.split(":");
                titulo = partes[0];
                genero = partes[1];
                recaudacion = Double.parseDouble(partes[3]);
                duracion = Integer.parseInt(partes[2]);
                p = new Pelicula(titulo, genero, recaudacion, duracion);
                this.lista_pelis.add(p);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io) {
            System.out.println("Fallo al leer el fichero");
        }

    }


    public void guardarTexto(String ruta) {
        try {
            FileWriter fr = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fr);

            for (Pelicula p : this.lista_pelis) {
                pw.println(p.getNombre() + ":" +
                        p.getGenero() + ":" +
                        p.getDuracion() + ":" +
                        p.getRecaudacion());
            }

            pw.close();
            fr.close();
        } catch (IOException io) {
            System.out.println("Error al escribir el fichero");
        }
    }

    public void guardarBinario(String ruta) {
        try {
            FileOutputStream fos=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            for(Pelicula p:this.lista_pelis){
                oos.writeObject(p);
            }

            fos.close();
            oos.close();

        }catch(IOException io){
            System.out.println("error de fichero");
        }

    }

    public void cargarBinario(String ruta) {
        try {

            FileInputStream fis = new FileInputStream(ruta);
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.lista_pelis.clear();
            while (fis.available() > 0) {
                Pelicula p = (Pelicula) ois.readObject();
                this.lista_pelis.add(p);
            }

            fis.close();
            ois.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("No se encuentra el fichero");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Falla el casting");
        } catch (IOException io) {
            System.out.println("Fallo al leer el fichero");
        }
    }


    public String buscarPelicula(String titulo) {
        Pelicula buscado = encontrarPeli(titulo);
        String res;
        if (buscado == null) {
            res = "No existe esa pelicula";
        } else {
            res = buscado.toString();
        }
        return res;
    }

    public double dineroSuperheroes() {
        double res = 0.0;
        for (Pelicula p : this.lista_pelis) {
            if (p.getGenero().equalsIgnoreCase("superheroes")
                    && p.getDuracion() > 100) {
                res += p.getRecaudacion();
            }
        }
        return res;
    }

    public void exportarmejores(String ruta) {
        try {
            FileWriter fr = new FileWriter(ruta);
            PrintWriter pw = new PrintWriter(fr);

            pw.println("<cine>");

            for (Pelicula p : this.lista_pelis) {
                pw.println("\t<pelicula>");
                pw.println("\t\t<titulo>"+p.getNombre() + "</titulo>\n" +
                        "\t\t<genero>"+p.getGenero() + "</genero>\n" +
                        "\t\t<recaudacion>"+p.getRecaudacion() + "</recaudacion>\n" +
                        "\t\t<duracion>"+p.getDuracion()+"</duracion>\n");
                pw.println("\t</pelicula>");
            }
            pw.println("<cine>");
            pw.close();
            fr.close();
        } catch (IOException io) {
            System.out.println("Error al escribir el fichero");
        }

    }

}
