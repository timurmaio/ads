package dataStructures.heaps

/**
 * Двоичная куча.
 *
 * Кучи реализуют очередь с приоритетами.
 * Основная идея реализации - использование бинарного дерева.
 * Однако дерево не хранится в явном виде, оно задаётся массивом.
 *
 * Например, дерево с приоритетами
 *    x
 *  y   z
 *  будет представлено массивом
 *  [x][y][z]
 *
 *  Индексы увеличиваются на 1 по уровням от элемента к элементу слева направо, начиная с нуля.
 *  Индекс левого потомка: i * 2 + 1
 *  Индекс правого потомка: i * 2 + 2
 *  Индекс предка: (i-1)/2
 */
class Binary<T> : Heapable<HeapNode<T>, T> {
    private val nodes: List<HeapNode<T>> = emptyList()

    override val count: Int
        get() = this.nodes.size

    override fun insert(item: HeapNode<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun extractMaximal(): HeapNode<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun peekMaximal(): HeapNode<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changePriority(item: HeapNode<T>, newPriority: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(item: HeapNode<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun merge(heap: Heapable<HeapNode<T>, T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
