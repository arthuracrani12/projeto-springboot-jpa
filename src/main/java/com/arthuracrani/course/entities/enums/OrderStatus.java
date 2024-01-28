package com.arthuracrani.course.entities.enums;

public enum OrderStatus {
	
	//não é preciso atribuir o valor numerico (1),(2)... Porém se inserir algum outro valor quebra a order de ID 
	WAITTING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERD(4),
	CANCELED(5);	
	
	//como inserimos o valor numerico temos que implementara:
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	//metodo para converter um valor numero para paraa o tipo enumerado
	//static pois o metodo funciona sem precisar instanciar
	//passo um codigo e ele retornar o codigo status, EX: 1 retorna WAITTING_PAYMENT
	public static OrderStatus valueOf(int code) {
		//percorrer todos os valores do OrderStatus e testar se é codigo correspondente, se for retorna
		for (OrderStatus value: OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
