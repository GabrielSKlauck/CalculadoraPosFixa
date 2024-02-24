public class PilhaVetor<T> implements Pilha<T> {

	private T[] info;
	private int limite;
	private int tamanho;

	@SuppressWarnings("unchecked")
	public PilhaVetor(int limite) {
		info = (T[]) new Object[limite];
		this.limite = limite;
		this.tamanho = 0;
	}

	@Override
	public String toString() {
		String str = "[";
		for (int i = tamanho - 1; i >= 0; i--) {
			str += info[i] + ", ";
		}
		return str + "]";
	}

	@Override
	public void push(T v) {
		if (limite == tamanho) {
			throw new RuntimeException("Capacidade esgotada da pilha!");
		}
		info[tamanho] = v;
		tamanho += 1;
	}

	@Override
	public T pop() {
		T v;
		v = peek();
		if (estaVazia()) {
			throw new RuntimeException("Pilha esta vazia!");
		}
		tamanho -= 1;
		return v;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha esta vazia!");
		}
		return info[tamanho - 1];
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public void liberar() {
		while (!estaVazia()) {
			pop();
		}
	}
}
