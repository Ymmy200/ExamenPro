interface TipoComercio {
    double calcularDescuento(double descuentoBase);
}

class RopaNiño implements TipoComercio {
    @Override
    public double calcularDescuento(double descuentoBase) {
        return descuentoBase * 0.88;
    }
}

class ComponentesDePc implements TipoComercio {
    @Override
    public double calcularDescuento(double descuentoBase) {
        return descuentoBase * 0.804;
    }
}

class ZapatosNike implements TipoComercio {
    @Override
    public double calcularDescuento(double descuentoBase) {
        return descuentoBase * 0.75;
    }
}

public class CentroComercial {

    private String nombreTienda;
    private TipoComercio tipoComercio;
    private double descuentoBase;

    public CentroComercial(String nombreTienda, TipoComercio tipoComercio, double descuentoBase) {
        this.nombreTienda = nombreTienda;
        this.tipoComercio = tipoComercio;
        this.descuentoBase = descuentoBase;
    }

    public double calcularDescuentoTotal() {
        double descuentoAplicado;
        switch (tipoComercio.getClass().getSimpleName()) {
            case "RopaNiño":
                descuentoAplicado = tipoComercio.calcularDescuento(descuentoBase) * 0.88;
                break;
            case "ComponentesDePc":
                descuentoAplicado = tipoComercio.calcularDescuento(descuentoBase) * 0.804;
                break;
            case "ZapatosNike":
                descuentoAplicado = tipoComercio.calcularDescuento(descuentoBase) * 0.75;
                break;
            default:
                descuentoAplicado = 0; 
        }
        return descuentoAplicado;
    }

    public void imprimirDetallesTiendas() {
        System.out.println("Nombre de la tienda: " + nombreTienda);
        System.out.println("------------------------");
        System.out.println("Tipo de comercio: " + tipoComercio.getClass().getSimpleName());
        System.out.println("------------------------"); 
        System.out.println("Descuento base: " + descuentoBase);
        System.out.println("------------------------");
        System.out.println("Descuento total: " + calcularDescuentoTotal());
        System.out.println("------------------------"); 
    }
    

    public static void main(String[] args) {
        
        CentroComercial tiendaRopaNiño = new CentroComercial("Tienda de ropa de niños", new RopaNiño(), 0.40);
        tiendaRopaNiño.imprimirDetallesTiendas();

        CentroComercial tiendaComponentesDePc = new CentroComercial("Tienda de componentes de PC", new ComponentesDePc(), 0.15);
        tiendaComponentesDePc.imprimirDetallesTiendas();

        CentroComercial tiendaZapatosNike = new CentroComercial("Tienda de zapatos Nike", new ZapatosNike(), 0.30);
        tiendaZapatosNike.imprimirDetallesTiendas();
    }
}




