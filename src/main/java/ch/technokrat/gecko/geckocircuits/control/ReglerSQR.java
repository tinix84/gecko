/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations GmbH
 *
 *  GeckoCIRCUITS is free software: you can redistribute it and/or modify it under 
 *  the terms of the GNU General Public License as published by the Free Software 
 *  Foundation, either version 3 of the License, or (at your option) any later version.
 *
 *  GeckoCIRCUITS is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 *  PURPOSE.  See the GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License along with
 *  GeckoCIRCUITS.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.technokrat.gecko.geckocircuits.control;

import ch.technokrat.gecko.geckocircuits.control.calculators.SquareCalculator;
import ch.technokrat.gecko.geckocircuits.control.calculators.AbstractControlCalculatable;
import ch.technokrat.gecko.i18n.resources.I18nKeys;
import java.awt.Window;

public final class ReglerSQR extends AbstractReglerSingleInputSingleOutput {
    static final ControlTypeInfo TYPE_INFO = new ControlTypeInfo(ReglerSQR.class, "SQR", I18nKeys.SQUARE);

    @Override
    public String[] getOutputNames() {
         return new String[]{"square"};
    }           
    
    @Override
    public AbstractControlCalculatable getInternalControlCalculatableForSimulationStart() {
        return new SquareCalculator();        
    }    

    @Override
    protected Window openDialogWindow() {
        return new DialogSimpleInfoMessage(this, "y1 = (x1)^2");
    }

    
    @Override
    public I18nKeys[] getOutputDescription() {
        return new I18nKeys[]{I18nKeys.SQUARE_OF_INPUT_DESCRIPTION};
    }    
}
