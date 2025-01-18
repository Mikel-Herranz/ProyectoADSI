package modelo;
import java.util.concurrent.TimeUnit;

public class Timer48Horas {
    private long Mmillis;
    private Thread timerThread;
    
    public Timer48Horas() {
        // Inicializa el tiempo total a 48 horas en milisegundos
    	
        this.Mmillis = TimeUnit.HOURS.toMillis(48);
        
    }
    
    public void start() {
        timerThread = new Thread(() -> {
            long remainingTime = Mmillis;

            while (remainingTime > 0) {
                try {
                    // Mostrar el tiempo restante en formato horas:minutos:segundos
                    System.out.println(formatTime(remainingTime));
                    // Pausar el hilo por 1 segundo
                    Thread.sleep(1000);
                    // Reducir el tiempo restante en 1 segundo
                    remainingTime -= 1000;
                } catch (InterruptedException e) {
                    System.err.println("El temporizador fue interrumpido.");
                    return;
                }
            }
            
            System.out.println("¡El tiempo ha terminado!");
            
           
        });

        timerThread.start();
    }
    
    

    // Formatear el tiempo restante en horas:minutos:segundos
    private String formatTime(long millis) {
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        return String.format("Tiempo restante: %02d:%02d:%02d", hours, minutes, seconds);
    }
}
