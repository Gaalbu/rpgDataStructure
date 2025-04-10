public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Menu menu = new Menu();
        //menu.iniciar();
        ListaEn lista = new ListaEn();
        lista.add("aaaaa");
        lista.add("aaaaa");
        lista.add("uuuuuuuh");
        System.out.println(lista.tamanho());
    }
}
