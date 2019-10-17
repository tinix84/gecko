/*  This file is part of GeckoCIRCUITS. Copyright (C) ETH Zurich, Gecko-Simulations AG
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

//package expressionscripting;
//
//import javax.script.ScriptException;
//
//class ConstantExpression extends AbstractExpression {
//
//    private final Double _constantReturnValue;    
//    
//    ConstantExpression(final Object nameable, final VariableExpression possibleReturnValue) 
//            throws ScriptException {
//        super(nameable, possibleReturnValue._scriptingCodeGivenFromUser);
//        _constantReturnValue = possibleReturnValue.evaluate();                
//    }
//
//    @Override
//    Double evaluate() throws ScriptException {
//        return _constantReturnValue;
//    }
//    
//}