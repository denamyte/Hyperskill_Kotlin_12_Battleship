fun solution(elements: Set<String>, element: String) =
    elements.toMutableSet().apply { remove(element) }