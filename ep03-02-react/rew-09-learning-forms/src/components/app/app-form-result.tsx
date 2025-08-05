import { useFormResult } from "@/lib/context/form-result-context"

export default function AppFormResult() {

    const {result} = useFormResult()

    return (
        <section>
            <h3 className="text-lg">Form Result</h3>

            <div className="pt-3">
                {result && 
                    <pre className="p-4 bg-black text-white rounded-md">{result}</pre>
                }
            </div>
        </section>
    )
}