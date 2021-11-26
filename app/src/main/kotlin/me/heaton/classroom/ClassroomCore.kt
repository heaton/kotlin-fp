package me.heaton.classroom

object ClassroomCore {
    fun absentReport(applied: List<Int>, showed: List<Int>) = applied - showed.toSet()

    fun attendReport(applied: List<Int>, showed: List<Int>) = applied intersect showed.toSet()

    fun extraAttendReport(applied: List<Int>, showed: List<Int>) = showed - applied.toSet()

    data class Invoice(val id: Int, val showDays: Int, val absentDays: Int, val total: Int)

    fun invoice(price: Int, applied: List<Int>, vararg days: List<Int>) = { id: Int ->
        val showDays = days.toList().flatten().count { it == id }
        val absentDays = days.toList().flatMap { absentReport(applied, it) }.count { it == id }
        Invoice(id, showDays, absentDays, showDays * price + absentDays * price / 2)
    }

}