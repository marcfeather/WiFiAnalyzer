/*
 * WiFiAnalyzer
 * Copyright (C) 2015 - 2020 VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.vrem.wifianalyzer.wifi.graphutils

import com.jjoe64.graphview.LegendRenderer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

class GraphLegendTest {
    private val legendRenderer = Mockito.mock(LegendRenderer::class.java)

    @After
    fun tearDown() {
        verifyNoMoreInteractions(legendRenderer)
    }

    @Test
    fun testSortByNumber() {
        assertEquals(3, GraphLegend.values().size.toLong())
    }

    @Test
    fun testGetDisplay() {
        assertEquals(GraphLegend.HIDE.legendDisplay, legendDisplayNone)
        assertEquals(GraphLegend.LEFT.legendDisplay, legendDisplayLeft)
        assertEquals(GraphLegend.RIGHT.legendDisplay, legendDisplayRight)
    }

    @Test
    fun testDisplayHide() {
        // execute
        GraphLegend.HIDE.display(legendRenderer)
        // validate
        verify(legendRenderer).isVisible = false
    }

    @Test
    fun testDisplayLeft() {
        // execute
        GraphLegend.LEFT.display(legendRenderer)
        // validate
        verify(legendRenderer).isVisible = true
        verify(legendRenderer).setFixedPosition(0, 0)
    }

    @Test
    fun testDisplayRight() {
        // execute
        GraphLegend.RIGHT.display(legendRenderer)
        // validate
        verify(legendRenderer).isVisible = true
        verify(legendRenderer).align = LegendRenderer.LegendAlign.TOP
    }
}