package io.titandata.titan.providers.local

import io.titandata.titan.clients.Docker
import io.titandata.titan.utils.CommandExecutor
import org.junit.Test
import kotlin.test.assertEquals
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class StopTest {
    private val executor = mock<CommandExecutor> {
        on {exec(listOf("docker","start","container"))} doReturn ""
    }
    private val docker = Docker(executor)
    private val command = Stop(executor, docker)

    @Test
    fun `can instantiate`(){
        assertThat(command, instanceOf(Stop::class.java))
    }

    @Test
    fun `can start`(){
        val byteStream = ByteArrayOutputStream()
        System.setOut(PrintStream(byteStream))
        command.stop("container")
        byteStream.flush()
        val expected = String(byteStream.toByteArray()).trim()
        assertEquals(expected, "container stopped")
    }
}