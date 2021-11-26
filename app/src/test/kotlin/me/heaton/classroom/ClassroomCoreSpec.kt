package me.heaton.classroom

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import me.heaton.classroom.ClassroomCore.absentReport
import me.heaton.classroom.ClassroomCore.attendReport
import me.heaton.classroom.ClassroomCore.extraAttendReport
import me.heaton.classroom.ClassroomCore.invoice

class ClassroomCoreSpec : WordSpec({
    "Classroom management" should {
        "generate absent report based on the applied list" {
            absentReport(listOf(1, 2, 3), listOf(1, 2, 4)) shouldBe listOf(3)
        }

        "generate attendees report based on the applied list" {
            attendReport(listOf(1, 2, 3), listOf(1, 2, 4)) shouldBe listOf(1, 2)
        }

        "generate extra attendees report based on the applied list" {
            extraAttendReport(listOf(1, 2, 3), listOf(1, 2, 4)) shouldBe listOf(4)
        }

        """create invoice by rules:
             * applied and attended => full charge
             * applied and absent => half charge
             * not applied but attended => full charge
             * not applied and not attended => no charge
        """ {
            val createInvoiceFor = invoice(100, listOf(1, 2, 3), listOf(1, 2, 4), listOf(2, 3, 4), listOf(1, 2, 3))
            createInvoiceFor(1).total shouldBe 250
            createInvoiceFor(2).total shouldBe 300
            createInvoiceFor(3).total shouldBe 250
            createInvoiceFor(4).total shouldBe 200
        }
    }
})