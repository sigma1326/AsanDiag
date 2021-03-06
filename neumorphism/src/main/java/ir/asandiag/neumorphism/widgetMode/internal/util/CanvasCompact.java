package ir.asandiag.neumorphism.widgetMode.internal.util;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;

import androidx.annotation.NonNull;

public class CanvasCompact {
    public static boolean clipOutPath(@NonNull Canvas canvas, @NonNull Path path) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return canvas.clipOutPath(path);
        } else {
            return canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
    }
}
