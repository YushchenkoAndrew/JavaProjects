package main.java.com.lab111.labwork9;

import article.FilesReaderWriter;

public class FileReader extends FilesReaderWriter {

    public FileReader() {
        super();
    }

    public FileReader(String path) {
        super(path);
    }

    @Override
    public void readFile() {
        super.readFile();

        for(StringBuilder line  : fileLines) {
            creatingShapes(line);
        }
    }

    private void creatingShapes(StringBuilder line) {
        switch (line.charAt(0)) {
            case 'O' : {
                action.director.add(new OvalBuilder());
                break;
            }
            case 'R' : {
                action.director.add(new RectangleBuilder());
                break;
            }
            case 'T' : {
                action.director.add(new TriangleBuilder());
                break;
            }
            case 'L' : {
                action.director.add(new LineBuilder());
                break;
            }
        }

        StringBuilder data = new StringBuilder();
        int[] shapeData = new int[8];
        int counter = 0;
        boolean writeData = false;
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == ',') {
                writeData = false;
                shapeData[counter++] = Integer.parseInt(data.toString());
                data = new StringBuilder();
                continue;
            }
            if (writeData)
                data.append(line.charAt(i));

            if (line.charAt(i) == ' ') {
                writeData = true;
            }
        }
        shapeData[counter] = Integer.parseInt(data.toString());

        action.director.builders.get(action.director.builders.size() - 1).buildShape(shapeData);
    }

    @Override
    public void setReadFilePath(String path) {
        super.setReadFilePath(path);
    }

    Action action;

    public void setAction(Action action) {
        this.action = action;
    }
}
