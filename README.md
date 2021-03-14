<h1>Image Processor Project</h1>
<h3>Description:</h3>
<p>
The image processor tool is implemented by JAVAFX. </br>
It allows users to:
</p>
<ul>
<li>Upload image(through drag and drop or by document finder), support jpg, png, gif or bmp</li>
<li>Display image properties, such as height, width, location, last modified time</li>
<li>Modify the uploaded image(Brighter, Darker, Greyer, Invert Color, More Saturated, More Unsaturated, Revert).</li>
<li>Download the modified image as jpg, png, gif or bmp</li>
</ul>
<h3>Demo:</h3>
<a href="https://github.com/JSLlan/ImageProcessor/blob/main/Test-Screens-PDF.pdf">Test_Screens_PDF</a>
<h3>Class Diagram:</h3>
<a href="https://github.com/JSLlan/ImageProcessor/blob/main/JavaFX_Class_Diagram.pdf">Class_Diagram</a>
<h3>Project Structure:</h3>
<p>
scene -> stackPane -> vbox -> imageGroup, btnBuilder (accessBox, filterBox)
</p>
<h3>Design Pattern:</h3>
<p>
Adapter pattern
</p>
<h3>How to run:</h3>
<p>
Download project, and import it to IntelliJ IDEA.
</br>
Edit run&debug configuration dialog:
<ul>
<li>VM options: --module-path /Users/stephanie/IdeaProjects/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml</li>
<li>Working directory: the current project path</li>
<li>Main class: sample.Main</li>
<li>Click ok to close dialog</li>
</ul>
Hit the run button.
</p>
