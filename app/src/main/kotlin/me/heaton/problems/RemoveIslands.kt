package me.heaton.problems

object RemoveIslands {
    data class Position(val x: Int, val y: Int)
    data class Size(val width: Int, val height: Int)
    data class Space(val size: Size, val lands: Set<Position>)

    fun removeIslands(matrix: String): String =
        if (matrix.isEmpty()) matrix
        else space(matrix).keepLands().toMatrix()

    private fun space(matrix: String) = matrix.lines().let { rows ->
        Space(
            Size(rows[0].length, rows.size),
            rows.foldIndexed(emptySet()) { y, acc, row ->
                acc + row.foldIndexed(emptySet()) { x, accr, cell ->
                    if (cell == '1') accr + Position(x, y) else accr
                }
            }
        )
    }

    private fun Space.keepLands(): Space =
        lands.partition { isEdge(it) }.let { (edges, nonEdges) ->
            copy(lands = edges.fold(Pair(emptySet(), nonEdges.toSet()), ::collectLands).first + edges)
        }

    private fun Space.isEdge(p: Position): Boolean = p.x % (size.width - 1) == 0 || p.y % (size.height - 1) == 0

    private fun collectLands(acc: Pair<Set<Position>, Set<Position>>, c: Position): Pair<Set<Position>, Set<Position>> =
        c.neighbours().intersect(acc.second).let { connectedLands ->
            if (connectedLands.isEmpty()) acc
            else connectedLands.fold(Pair(acc.first + connectedLands, acc.second - connectedLands), ::collectLands)
        }

    private fun Position.neighbours() = listOf(-1, 1).flatMap { i ->
        listOf(Position(x + i, y), Position(x, y + i))
    }

    private fun Space.toMatrix() =
        (0 until size.height).joinToString("\n") { y ->
            (0 until size.width).joinToString("") { x ->
                if (lands.contains(Position(x, y))) "1" else "0"
            }
        }

}