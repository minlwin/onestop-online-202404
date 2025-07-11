import { useEffect, useRef } from "react"

type Modal = {
    show: () => void
    hide: () => void
}

declare const bootstrap: {
    Modal: new (element: HTMLElement, props : {backdrop? : 'static'}) => Modal
}

export default function ModalDialog({title, show, children, onHide, onSave} : ModalProps) {
    
    const dialogRef = useRef<HTMLElement | null>(null)
    const modalRef = useRef<Modal | null>(null)

    useEffect(() => {
        const current = dialogRef.current
        if (current && !modalRef.current) {
            modalRef.current = new bootstrap.Modal(current, {backdrop: 'static'})
        }

        if (show) {
            modalRef.current?.show()
        } else {
            modalRef.current?.hide()
        }
    }, [show, dialogRef, modalRef])
    
    return (
        <section className="modal fade" ref={dialogRef}>
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h3 className="modal-title">{title}</h3>
                    </div>

                    <div className="modal-body">
                        {children}
                    </div>

                    {(onHide || onSave) && 
                        <div className="modal-footer">
                            {onHide &&
                                <button type="button" className="btn btn-secondary" onClick={onHide}>
                                    <i className="bi-x"></i> Close
                                </button>
                            }

                            {onSave &&
                                <button type="button" className="btn btn-primary" onClick={onSave}>
                                    <i className="bi-check"></i> Save changes
                                </button>
                            }
                        </div>
                    }
                </div>                
            </div>
        </section>
    )
}

type ModalProps = {
    title : string
    show : boolean
    onHide? : () => void
    onSave? : () => void
    children : React.ReactNode
}