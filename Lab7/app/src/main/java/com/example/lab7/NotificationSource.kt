package com.example.lab7



data class Notification(
    val title: String,
    val content: String,
    val date: String,
    val time: String,
    val type: NotificationType,
)

enum class NotificationType {
    Informativas,
    Capacitaciones,
    Alertas,
    Actualizaciones
}

fun generateFakeNotifications(): List<Notification> {
    return listOf(
        Notification(
            title = "Nueva versión disponible",
            content = "La aplicación ha sido actualizada a v1.1.0. Ve a la PlayStore y actualiza!",
            date = "19 ago",
            time = "2:30 p.m.",
            type = NotificationType.Informativas,
        ),
        Notification(
            title = "Nueva capacitación",
            content = "El día Martes 21 de Agosto tendremos una nueva capacitación en el INTECAP! No faltes!",
            date = "15 ago",
            time = "3:00 p.m.",
            type = NotificationType.Capacitaciones,
        ),
        Notification(
            title = "Alerta de seguridad",
            content = "Se ha detectado una actividad inusual en tu cuenta. Por favor, revisa tus accesos recientes.",
            date = "20 ago",
            time = "1:00 p.m.",
            type = NotificationType.Alertas,
        ),
        Notification(
            title = "Actualización de políticas",
            content = "Las políticas de privacidad han sido actualizadas. Asegúrate de revisarlas.",
            date = "18 ago",
            time = "10:00 a.m.",
            type = NotificationType.Actualizaciones,
        ),
        Notification(
            title = "Nueva versión disponible",
            content = "La aplicación ha sido actualizada a v1.2.0. Ve a la PlayStore y actualiza!",
            date = "25 ago",
            time = "9:30 a.m.",
            type = NotificationType.Informativas,
        ),
        Notification(
            title = "Nueva capacitación",
            content = "El día Jueves 24 de Agosto tendremos una nueva capacitación en el INTECAP! No faltes!",
            date = "24 ago",
            time = "4:00 p.m.",
            type = NotificationType.Capacitaciones,
        ),
        Notification(
            title = "Alerta de seguridad",
            content = "Se ha detectado una actividad sospechosa en tu cuenta. Por favor, cambia tu contraseña.",
            date = "23 ago",
            time = "11:00 a.m.",
            type = NotificationType.Alertas,
        ),
        Notification(
            title = "Actualización de políticas",
            content = "Hemos actualizado nuestras políticas de uso. Asegúrate de revisarlas.",
            date = "22 ago",
            time = "12:00 p.m.",
            type = NotificationType.Actualizaciones,
        ),
        Notification(
            title = "Nueva versión disponible",
            content = "La aplicación ha sido actualizada a v1.3.0. No te pierdas las nuevas funciones!",
            date = "21 ago",
            time = "2:00 p.m.",
            type = NotificationType.Informativas,
        ),
        Notification(
            title = "Capacitación especial",
            content = "Capacitación especial el viernes 25 de agosto en la sede central.",
            date = "20 ago",
            time = "5:00 p.m.",
            type = NotificationType.Capacitaciones,
        ),
        Notification(
            title = "Alerta de seguridad",
            content = "Hemos bloqueado un intento de acceso no autorizado. Revisa tu cuenta.",
            date = "19 ago",
            time = "6:00 p.m.",
            type = NotificationType.Alertas,
        ),
        Notification(
            title = "Actualización de términos",
            content = "Nuestros términos y condiciones han cambiado. Te recomendamos revisarlos.",
            date = "18 ago",
            time = "9:00 a.m.",
            type = NotificationType.Actualizaciones,
        ),

        Notification(
            title = "Nueva versión disponible",
            content = "La aplicación ha sido actualizada a v1.4.0 con mejoras de rendimiento.",
            date = "17 ago",
            time = "7:00 a.m.",
            type = NotificationType.Informativas,
        ),
        Notification(
            title = "Capacitación en línea",
            content = "Capacitación en línea disponible el lunes 28 de agosto.",
            date = "16 ago",
            time = "8:00 a.m.",
            type = NotificationType.Capacitaciones,
        ),
        Notification(
            title = "Alerta de seguridad",
            content = "Tu cuenta ha sido marcada por actividad inusual. Revisa inmediatamente.",
            date = "15 ago",
            time = "2:30 p.m.",
            type = NotificationType.Alertas,
        ),
        Notification(
            title = "Actualización de interfaz",
            content = "Hemos mejorado la interfaz de usuario. Descubre lo nuevo ahora!",
            date = "14 ago",
            time = "3:00 p.m.",
            type = NotificationType.Actualizaciones,
        ),

        Notification(
            title = "Nuevo curso disponible",
            content = "Inscríbete ahora en el curso de desarrollo móvil!",
            date = "21 ago",
            time = "11:00 a.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Mantenimiento programado",
            content = "Habrá un mantenimiento de servidores el 25 de agosto a las 2:00 a.m.",
            date = "19 ago",
            time = "9:00 p.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Nueva funcionalidad agregada",
            content = "Explora la nueva sección de reportes en tu perfil.",
            date = "17 ago",
            time = "5:00 p.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Cambio en los términos de uso",
            content = "Nuestros términos de uso han sido actualizados. Por favor, léelos.",
            date = "16 ago",
            time = "8:30 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Sesión informativa",
            content = "Únete a la sesión informativa este viernes a las 3:00 p.m.",
            date = "14 ago",
            time = "12:00 p.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Curso de actualización",
            content = "Curso de actualización en Java el próximo lunes.",
            date = "13 ago",
            time = "10:00 a.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Advertencia de seguridad",
            content = "Tu cuenta ha sido bloqueada temporalmente por múltiples intentos fallidos.",
            date = "12 ago",
            time = "6:00 p.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Actualización de la app",
            content = "Nueva versión de la app disponible. Actualiza para acceder a nuevas funciones.",
            date = "11 ago",
            time = "9:00 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Invitación a evento",
            content = "Te invitamos al evento anual de tecnología el próximo sábado.",
            date = "10 ago",
            time = "7:00 p.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Capacitación avanzada",
            content = "Capacitación avanzada en Kotlin el martes a las 10:00 a.m.",
            date = "9 ago",
            time = "4:00 p.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Alerta de contraseña",
            content = "Es hora de cambiar tu contraseña. Ha pasado mucho tiempo desde el último cambio.",
            date = "8 ago",
            time = "2:30 p.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Mejoras en la interfaz",
            content = "La interfaz de la app ha sido mejorada para facilitar la navegación.",
            date = "7 ago",
            time = "8:00 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Nueva herramienta disponible",
            content = "Explora la nueva herramienta de análisis en la sección de reportes.",
            date = "6 ago",
            time = "10:30 a.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Capacitación en línea",
            content = "Capacitación en línea sobre seguridad informática el jueves.",
            date = "5 ago",
            time = "3:00 p.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Alerta de acceso sospechoso",
            content = "Detectamos un acceso desde un nuevo dispositivo. Verifica si fuiste tú.",
            date = "4 ago",
            time = "6:30 p.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Nueva política de privacidad",
            content = "Hemos actualizado nuestra política de privacidad. Por favor, revísala.",
            date = "3 ago",
            time = "11:00 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Notificación importante",
            content = "Por favor, revisa las nuevas políticas de la compañía.",
            date = "2 ago",
            time = "1:00 p.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Curso de primeros auxilios",
            content = "Capacitación sobre primeros auxilios disponible en el portal.",
            date = "1 ago",
            time = "9:00 a.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Aviso de seguridad",
            content = "Recuerda no compartir tu contraseña con nadie.",
            date = "31 jul",
            time = "5:00 p.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Nueva actualización disponible",
            content = "Actualiza la app para disfrutar de nuevas características.",
            date = "30 jul",
            time = "10:00 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Invitación a conferencia",
            content = "Participa en la conferencia sobre inteligencia artificial el próximo mes.",
            date = "29 jul",
            time = "2:00 p.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Taller de programación",
            content = "Inscríbete en el taller de programación para principiantes.",
            date = "28 jul",
            time = "4:00 p.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Cuidado con el phishing",
            content = "No abras correos electrónicos sospechosos para evitar el phishing.",
            date = "27 jul",
            time = "6:00 p.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Nuevas opciones de configuración",
            content = "Explora las nuevas opciones de configuración en tu perfil.",
            date = "26 jul",
            time = "8:00 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Noticia destacada",
            content = "Lee las últimas noticias sobre tecnología en nuestro blog.",
            date = "25 jul",
            time = "7:00 a.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Capacitación de seguridad",
            content = "Capacitación sobre seguridad de la información disponible en el portal.",
            date = "24 jul",
            time = "3:30 p.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Alerta de virus",
            content = "Un virus ha sido detectado en uno de tus dispositivos. Por favor, revisa.",
            date = "23 jul",
            time = "11:30 a.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Nueva actualización del sistema",
            content = "Actualiza tu sistema operativo para mejorar la seguridad.",
            date = "22 jul",
            time = "9:30 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Reunión de equipo",
            content = "Reunión de equipo programada para el viernes a las 2:00 p.m.",
            date = "21 jul",
            time = "10:00 a.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Curso sobre ciberseguridad",
            content = "Inscríbete en el curso sobre ciberseguridad que empieza la próxima semana.",
            date = "20 jul",
            time = "12:00 p.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Alerta de seguridad",
            content = "Un intento de inicio de sesión sospechoso fue bloqueado.",
            date = "19 jul",
            time = "3:00 p.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Nueva versión del software",
            content = "Actualiza el software para corregir errores y mejorar el rendimiento.",
            date = "18 jul",
            time = "8:00 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Nueva funcionalidad de chat",
            content = "Prueba la nueva funcionalidad de chat en la app.",
            date = "17 jul",
            time = "4:00 p.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Taller sobre privacidad",
            content = "Participa en el taller sobre privacidad de datos este viernes.",
            date = "16 jul",
            time = "6:00 p.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Advertencia de cuenta",
            content = "Tu cuenta podría estar comprometida. Cambia tu contraseña lo antes posible.",
            date = "15 jul",
            time = "9:00 a.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Actualización de sistema",
            content = "Se ha lanzado una nueva actualización de sistema. Por favor, actualiza.",
            date = "14 jul",
            time = "10:30 a.m.",
            type = NotificationType.Actualizaciones
        ),
        Notification(
            title = "Evento de networking",
            content = "Únete al evento de networking virtual este miércoles.",
            date = "13 jul",
            time = "5:00 p.m.",
            type = NotificationType.Informativas
        ),
        Notification(
            title = "Capacitación en nuevas tecnologías",
            content = "Explora las nuevas tecnologías en la capacitación del próximo mes.",
            date = "12 jul",
            time = "7:30 a.m.",
            type = NotificationType.Capacitaciones
        ),
        Notification(
            title = "Alerta de seguridad",
            content = "Ha habido un intento de inicio de sesión fallido. Revisa tu cuenta.",
            date = "11 jul",
            time = "11:00 a.m.",
            type = NotificationType.Alertas
        ),
        Notification(
            title = "Actualización disponible",
            content = "Una nueva actualización está disponible para mejorar la estabilidad de la app.",
            date = "10 jul",
            time = "8:00 a.m.",
            type = NotificationType.Actualizaciones
        )
    )
}
