(defparameter *min* 1)
(defparameter *max* 100)

(defun gissa-nummer ()
  (ash (+ *min* *max*) -1))

(defun mindre ()
  (setf *max* (1- (gissa-nummer)))
  (gissa-nummer))
(defun mer ()
  (setf *min* (1+ (gissa-nummer)))
  (gissa-nummer))

(defun omstart ()
  (defparameter *min* 1)
  (defparameter *max* 100)
  (gissa-nummer))
