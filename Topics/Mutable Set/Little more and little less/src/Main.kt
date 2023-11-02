fun solution(newSet: MutableSet<String>, oldSet: Set<String>) =
    "[Aa].*".toRegex().let {
        r -> newSet.apply {
            addAll(oldSet.filter { r.matches(it) } )
        }
    }