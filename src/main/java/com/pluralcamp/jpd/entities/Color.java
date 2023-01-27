package com.pluralcamp.jpd.entities;

public class Color {

	private long id = -1;
	private String name;
	private int red;
	private int green;
	private int blue;
	
	public static final int MAX_VALUE = 255;
	public static final int MIN_VALUE = 0;
	public static final String DEFAULT_NANE = "undefined";
	
	public Color(String name, int red, int green, int blue) {
		this.setName(name);
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
	}
	
	public Color(int red, int green, int blue) {
		this.setName(DEFAULT_NANE);
		this.setRed(red);
		this.setGreen(green);
		this.setBlue(blue);
	}
	
	public Color() {}
	
    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (this.getId() != -1) {
            throw new UnsupportedOperationException("No se puede cambiar el id de un objeto ya asignado");
        }
        if (id <= 0) {    
            throw new IllegalArgumentException("El id a asignar a una entidad debe ser un valor positivo");
        }        
        this.id = id;
    }	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Es obligatorio indicar el nombre del color!!");
        }
        this.name = name;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
        if (red < MIN_VALUE || red > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Valor %d no es válido "
            		+ "para la coordenada R. "
            		+ "Valores válidos: %d - %d", red, MIN_VALUE, MAX_VALUE));
        }
        this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
        if (green < MIN_VALUE || green > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Valor %d no es válido para la coordenada G. Valores válidos: %d - %d", green, MIN_VALUE, MAX_VALUE));
        }
        this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
        if (blue < MIN_VALUE || blue > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("Valor %d no es válido para la coordenada B. Valores válidos: %d - %d", blue, MIN_VALUE, MAX_VALUE));
        }
        this.blue = blue;
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%n-----------------------------------%n"));
        sb.append(String.format("   C O L O R%n"));
        sb.append(String.format("-----------------------------------%n"));
        sb.append(String.format("- Id:       %s %n", this.getId()));
        sb.append(String.format("- Nombre:   %s %n", this.getName()));
        sb.append(String.format("- RGB:      %s %n", this.toRGBString()));
        sb.append(String.format("- Hex:      %s %n", this.toHexString()));
        return sb.toString();
    }
    
    public String toRGBString(boolean upper) {
        return String.format("%s(%d, %d, %d)", upper ? "RGB": "rgb", this.getRed(), this.getGreen(), this.getBlue());
    }
    
    public String toRGBString() {
        return toRGBString(false);
    }
    
    public String toHexString(boolean upper) {
        return String.format(upper ? "#%02X%02X%02X" : "#%02x%02x%02x", this.getRed(), this.getGreen(), this.getBlue());
    }
    
    public String toHexString() {
        return toHexString(true);
    }
	
}
