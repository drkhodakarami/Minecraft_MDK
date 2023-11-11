# Minecraft_MDK
Different zip files of my own project templates to boost starting up a modding environment for both fabric and neoforge.

When you open the project in intellij, make sure to set the proper .gradle folder address. The project zip file contains .intellij folder and will save every gradle related download at "E:/.gradle". To change this address, go to Settings > Build, Execution, Deployment > Build Tools > Gradle. Under the General Settings, there is a filed for Gradel User Home. Change the address properly. This is done so that the gradle downloads won't fall into the default folder and occupy the main hard drive. If you want it in the default position, simply delete the address and leave the field empty. After setting the address, update the gradle build.

Alternatively, you can delete .intellij folder before opening the project. This will make you loose all the proper settings for java versioning and even some settings for custom font usage (Fira Code with Enabled Ligatures).

you can download Fira Code font from this repository or search online (it's a free font with the project sitting in github).