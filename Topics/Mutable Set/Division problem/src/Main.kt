fun solution(first: Set<Int>, second: Set<Int>) =
    first.filter { it % second.size == 0 }.toSet()