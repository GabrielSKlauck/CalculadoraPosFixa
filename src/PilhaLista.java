public class PilhaLista<T> implements Pilha<T> {

	private NoLista<T> primeiro;
	private int qtdeElementos;

	@Override
	public void push(T v) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(v);
		if (!this.estaVazia()) {
			novo.setProx(primeiro);
		}
		primeiro = novo;
		qtdeElementos++;
	}

	@Override
	public T pop() {
		T valor;
		valor = peek();
		primeiro = primeiro.getProx();
		qtdeElementos--;
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new RuntimeException("Pilha esta vazia");
		}
		return primeiro.getInfo();
	}

	@Override
	public boolean estaVazia() {
		return (primeiro == null);
	}

	@Override
	public void liberar() {
		while (!estaVazia()) {
			pop();
		}
	}

	public String toString() {
		NoLista<T> p = primeiro;
		String msg = "[";
		while (p != null) {
			msg += p.getInfo() + ", ";
			p = p.getProx();
		}
		return msg + "]";
	}
}