
export interface Media {
    id?: number;
    name: string;
    author: string;
    description: string;
    uploadBy: string;
    uploadDate: Date;
    type: string;


}

export class Media {
    constructor(media: Media) {
        {
            this.id = media.id;
            this.name = media.name || '';
            this.author = media.author || '';
            this.description = media.description || '';

            this.uploadBy = media.uploadBy || '';
            this.uploadDate = media.uploadDate || new Date;
            this.type = media.type;

        }
    }
}