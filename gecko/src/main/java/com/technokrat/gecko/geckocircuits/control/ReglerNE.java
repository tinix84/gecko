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
package gecko.geckocircuits.control;

import gecko.geckocircuits.allg.AbstractComponentTyp;
import gecko.geckocircuits.control.calculators.AbstractControlCalculatable;
import gecko.geckocircuits.control.calculators.NotEqualCalculator;
import gecko.i18n.resources.I18nKeys;

public final class ReglerNE extends SimpleRegelBlock {
    public static final ControlTypeInfo tinfo = new ControlTypeInfo(ReglerNE.class, "NE", I18nKeys.NOT_EQUAL);
    
    public ReglerNE() {
        super(2, 1);
    }

    @Override
    public String[] getOutputNames() {
        return new String[]{"ne"};
    }
    

    @Override
    public AbstractControlCalculatable getInternalControlCalculatableForSimulationStart() {
        return new NotEqualCalculator();        
    }            

    @Override
    public I18nKeys[] getOutputDescription() {
        return new I18nKeys[]{I18nKeys.NOT_EQUAL_DESCRIPTION};
    }
    
    @Override
    String getDialogMessage() {
        return "<html>x1 different x2  ...  y1 = 1<br>"
            + "x1 equal x2      ...  y1 = 0</html>";
    }
}
