<div class="WordSection1">

# Resolución

Se creó la clase <span class="SpellE">CallDispacher</span> que recibe llamadas y se le asignan empleados, asincrónicamente va asignando las llamados en espera a los empleados disponibles quienes van a atender dichos llamados. Cuando un empleado termina de atender una llamada se vuelve a cargar ese tipo de empleado a la cola de <span class="SpellE">employeesAvailable</span>.

# Unit Test

El test unitario está dentro del test de la aplicación, allí se crea una instancia de Dispatcher y se indica cuantas llamadas concurrentes deberá procesar.

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Primer Test -> testTresLLamadas. Entran 3 llamas, las cuales van a ser atentidas solo por el Operador dejando en esperas las otras hasta que termine con cada una.

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Segundo Test -> testDiezLLamadas. Entran 10 llamas al tiempo, y van a ser atendidas por los 3 actores en el orden principal, "Operador,Supervisor y Director", a medida que se vayan librando van atendiendo la llamada en espera manteniendo el orden de los actores.

<span style="font-family:Symbol;mso-fareast-font-family:Symbol;mso-bidi-font-family:
Symbol"><span style="mso-list:Ignore">·<span style="font:7.0pt &quot;Times New Roman&quot;">        </span> </span></span>Agregar los <span class="SpellE">tests</span> unitarios que se crean convenientes. Agregar documentación de código.

### Extras/Plus solución

De la siguiente manera se solucionan los puntos Extras/Plus de la posibilidad de no tener empleado libre y la posibilidad de tener más de 10 llamadas concurrentes.

* Para la cola de llamadas se utiliza <span class="SpellE"><span class="GramE">java.util.concurrent.LinkedBlockingQueue</span> que es una implementación de <span class="SpellE">BlockingQueue</span> y se caracteriza por mantener el hilo a la espera cuando se quiere sacar un elemento de una cola vacía.

Para la cola de <span class="SpellE">employeesAvailable</span> utilicé java.util.concurrent.PriorityBlockingQueue que la única diferencia con la de llamadas es que está priorizada para que tome primero a los Operadores, luego a los Supervisores y por ultimo a los Directores.

</div>
