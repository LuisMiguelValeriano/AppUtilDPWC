/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases.Core;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author lvaleriano
 */
public class C_ComponentFrame {
    public void setEnableJPanelComponents(Component []components, boolean Enabled){
        if(components.length > 0){
            for (Component component : components) {
                component.setEnabled(Enabled);
            }
        }
    }
    public void setEnableJPanelComponentsWithCheckBox(JPanel panel, JCheckBox checkbox){
        if(checkbox.isSelected()){
            setEnableJPanelComponents(panel.getComponents(), true);
        }else{
            setEnableJPanelComponents(panel.getComponents(), false);
        }
    }
}
