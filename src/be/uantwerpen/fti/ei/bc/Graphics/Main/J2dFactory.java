package be.uantwerpen.fti.ei.bc.Graphics.Main;

import be.uantwerpen.fti.ei.bc.Game.Main.AFactory;
import be.uantwerpen.fti.ei.bc.Game.Main.GraphicsClass;
import be.uantwerpen.fti.ei.bc.Game.Entities.TestSquare;
import be.uantwerpen.fti.ei.bc.Graphics.Entities.J2dTestSquare;

public class J2dFactory extends AFactory {

    private J2dGraph graph;

    public J2dFactory() {
//        graph = new J2dGraph();
    }

    public GraphicsClass createGraphicsClass(){
        graph =  new J2dGraph();
        return graph;
    }

    @Override
    public TestSquare createTS(int x, int y, double dx, double dy) {
        return new J2dTestSquare(graph, x, y, dx, dy);
    }


}
